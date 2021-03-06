package com.nacos.common.aspect;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 为了动态获取日志，在不同的工程里实现对应的bean 通过spring 自动注入到 LogAnnotationAspect
 */
public interface ProAfter {
    Object aroundMethod(ProceedingJoinPoint pjd) throws Exception;
}
