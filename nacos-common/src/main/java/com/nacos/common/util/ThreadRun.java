package com.nacos.common.util;

public interface ThreadRun<T> {
  T run() throws Exception;
}
