package com.nacos.common.util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ServicesCountDown<T> {
  Map<String,T> reusltMps = new HashMap<>();
  HashMap<String,ServiceThread<T>> runs = new HashMap<>();
  static final int nThreads = Runtime.getRuntime().availableProcessors();

  // 开启线程池
  ExecutorService pool = null;
  CountDownLatch count = null;

  /**
   * 初始化现成
   * @param size
   * @param threadSize
   * @return
   */
  public ServicesCountDown<T> init(int size, int threadSize){
    count = new CountDownLatch(size);
    pool = Executors.newFixedThreadPool(threadSize);
    return this;
  }

  public ServicesCountDown<T> runs() throws InterruptedException {
    if (pool == null) {
      pool = Executors.newFixedThreadPool(nThreads);
      count = new CountDownLatch(runs.size());
    }
    ConcurrentHashMap<String, Future> futures = new ConcurrentHashMap<>();
    runs.forEach((k,run)->{
      futures.put(k,pool.submit(run));
    });
    futures.forEach((k,run) -> {
      try {
        reusltMps.put(k,(T)run.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    });
    count.countDown();
    pool.shutdown();
    return this;
  }

  private ServletRequestAttributes getHttpServletRequest() {
    try {
      // 这种方式获取的HttpServletRequest是线程安全的
      return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()));
    } catch (Exception e) {
      return null;
    }
  }

  public ServicesCountDown<T> addRun(String asName, ThreadRun<T> threadRun) {
    runs.put(asName,new ServiceThread<T>().setRun(threadRun, getHttpServletRequest()));
    return this;
  }

  /**
   * 验证返回数据 如果有null值 直接抛出异常
   * @return
   */
  public ServicesCountDown<T> checkValues() throws Exception {
    for(Object result: reusltMps.values()) {
      if (result == null) {
        throw new Exception("返回的数据有null值");
      }
    }
    return this;
  }

  // 返回结果集
  public Map<String,T> reusltValues(){
    return reusltMps;
  }
}
