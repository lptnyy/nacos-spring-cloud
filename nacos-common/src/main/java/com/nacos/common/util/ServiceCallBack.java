package com.nacos.common.util;

@FunctionalInterface
public interface ServiceCallBack {
    ServiceResponse run();
}
