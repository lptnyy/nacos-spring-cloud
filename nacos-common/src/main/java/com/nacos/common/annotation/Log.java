package com.nacos.common.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default ""; // 日志内容
    String name() default ""; // 日志名称
    String source() default ""; // 添加来源用于区分日志来源 比如某某功能 某某服务 某某业务
}
