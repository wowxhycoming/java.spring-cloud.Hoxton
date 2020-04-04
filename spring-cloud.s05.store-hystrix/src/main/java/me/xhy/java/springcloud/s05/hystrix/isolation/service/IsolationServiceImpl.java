package me.xhy.java.springcloud.s05.hystrix.isolation.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

@Component
public class IsolationServiceImpl {

  /*
  在调用 isolationConsume 方法是，先要执行 HystrixCommand 逻辑，通过后才会调用 isolationConsume
   */
  @HystrixCommand(
      fallbackMethod = "isolationFallback", // 降级方法
      commandKey = "isolationByThread",
      groupKey = "isolationByThreadGroup",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"), // 线程池模式， 默认值是 THREAD
          /*@HystrixProperty(name = "execution.timeout.enable", value = "true"), // HystrixCommand.run()的执行是否启用超时时间，默认为 true。
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000" ), // hystrix 超时时间
          @HystrixProperty(name = "circuitBreaker.enabled", value = "true" ), //开启熔断器
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "3" ), // 窗口时间内多少个请求失败了，会打开断路器*/
      },
      threadPoolKey = "isolationByThreadPool",
      threadPoolProperties = {
          @HystrixProperty(name = "coreSize", value = "10"), // 线程池和信号量的默认值都是 10
          /*@HystrixProperty(name = "maxQueueSize", value = "10"),
          @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
          @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
          @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
          @HystrixProperty(name = "metrics.rollingStats.time", value = "1440")*/
      }
  )
  public String isolationByThread() {
    System.out.println("Service Thread -> " + Thread.currentThread().getName());
    return "this is a tagged method by Hystrix";
  }

  @HystrixCommand(
      fallbackMethod = "isolationFallback", // 降级方法
      commandKey = "isolationBySemaphore",
      groupKey = "isolationBySemaphoreGroup",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), // 线程池模式， 默认值是 THREAD
          @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "10"),
          /*@HystrixProperty(name = "execution.timeout.enable", value = "true"), // HystrixCommand.run()的执行是否启用超时时间，默认为 true。
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000" ), // hystrix 超时时间
          @HystrixProperty(name = "circuitBreaker.enabled", value = "true" ), //开启熔断器
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "3" ), // 窗口时间内多少个请求失败了，会打开断路器*/
      }
  )
  public String isolationBySemaphore() {
    System.out.println("Service Thread -> " + Thread.currentThread().getName());
    return "this is a tagged method by Hystrix";
  }

  public String isolationFallback() {
    System.out.println("Service Thread fallback -> " + Thread.currentThread().getName());
    return "function isolationConsume is isolated";
  }
}
