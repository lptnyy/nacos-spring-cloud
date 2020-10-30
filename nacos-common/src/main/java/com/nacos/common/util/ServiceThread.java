package com.nacos.common.util;
import java.util.concurrent.Callable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ServiceThread<T> implements Callable {
  ThreadRun<T> threadRun = null;
  ServletRequestAttributes servletRequestAttributes;

  @Override
  public T call() {
    try {
      RequestContextHolder.setRequestAttributes(servletRequestAttributes);
      return threadRun.run();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public ServiceThread<T> setRun(ThreadRun<T> threadRun, ServletRequestAttributes servletRequestAttributes) {
    this.threadRun = threadRun;
    this.servletRequestAttributes = servletRequestAttributes;
    return this;
  }
}
