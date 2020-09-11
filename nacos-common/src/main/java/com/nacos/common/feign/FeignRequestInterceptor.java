package com.nacos.common.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import io.seata.core.context.RootContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * feign 熔断器开启之后 传递 token验证header 头使用
 */
public class FeignRequestInterceptor implements RequestInterceptor {

    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request = getHttpServletRequest();
        if (Objects.isNull(request)) {
            return;
        }
        Map<String, String> headers = getHeaders(request);
        if (headers.size() > 0) {
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                requestTemplate.header(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            // 这种方式获取的HttpServletRequest是线程安全的
            return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        } catch (Exception e) {

            return null;
        }
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enums = request.getHeaderNames();
        String kid = (String) request.getAttribute(RootContext.KEY_XID);
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        if (kid != null && !kid.equals("")) {
            map.put(RootContext.KEY_XID, kid);
        }
        return map;
    }
}

