package com.nacos.backstage.configuration.aspect;

import com.alibaba.fastjson.JSON;
import com.nacos.common.annotation.Authority;
import com.nacos.common.annotation.Log;
import com.nacos.common.aspect.ProAfter;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.util.SystemClock;
import com.nacos.system.IProLogService;
import com.nacos.system.request.ProLogRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 实现一个自定义日志收集aop拦截器，对应注解 com.wzy.common.annotation.Log 最好使用异步处理日志
 */
@Component
public class ProAferConfiguration implements ProAfter {

    @Autowired
    IProLogService proLogService;

    @Override
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        long startTime= SystemClock.now();
        try {
            Class<?> classTarget = pjd.getTarget().getClass();
            String className = pjd.getTarget().getClass().getSimpleName();
            String methodName = pjd.getSignature().getName();
            Class<?>[] par = ((MethodSignature) pjd.getSignature()).getParameterTypes();
            Method objMethod = classTarget.getMethod(methodName, par);

            // 是否支持验证权限
            Authority authority = objMethod.getAnnotation(Authority.class);
            if (authority != null) {
                SecurityContext context = SecurityContextHolder.getContext();
                Collection<? extends GrantedAuthority> auths = context.getAuthentication().getAuthorities();
                Object[] authStr = auths.toArray();
                String[] autStrs = authority.values();
                Optional<Object> result = Arrays.stream(authStr).filter(str -> {
                    for(String aut: autStrs) {
                        if (aut.equals(str.toString())) {
                            return true;
                        }
                    }
                    return false;
                }).findFirst();
                if(result.isPresent()) {
                    if (result.get() == null) {
                        return ServiceResponse.getAuthFAIL();
                    }
                } else {
                    return ServiceResponse.getAuthFAIL();
                }
            }

            // 查看是否支持日志收集
            Object result = pjd.proceed(pjd.getArgs());
            Log log = objMethod.getAnnotation(Log.class);
            if (log != null) {
                ProLogRequest proLog = new ProLogRequest();
                String bodyJson = JSON.toJSONString(pjd.getArgs());
                String returnJson = JSON.toJSONString(result);
                proLog.setName(log.name());
                proLog.setValue(log.value());
                proLog.setSource(log.source());
                proLog.setBody(bodyJson);
                proLog.setClassName(className);
                proLog.setFunctionName(methodName);
                proLog.setReturnBody(returnJson);
                long endTime=SystemClock.now();
                proLog.setRunTime((float) (endTime - startTime));
                proLogService.save(new ProParameter<>(proLog));
            }
            return result;
        } catch (Throwable throwable) {
            return ServiceResponse.getAuthFAIL();
        }
    }
}
