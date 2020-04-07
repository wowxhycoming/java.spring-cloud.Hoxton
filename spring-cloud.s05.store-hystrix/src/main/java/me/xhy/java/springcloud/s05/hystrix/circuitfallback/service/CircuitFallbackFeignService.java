package me.xhy.java.springcloud.s05.hystrix.circuitfallback.service;

import feign.hystrix.FallbackFactory;
import net.minidev.json.JSONUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

// 直接在 FeignClient 注解中使用 fallback 指定降级方法是有弊端的，这种方式的弊端在于，无论是`原方法`还是`降级方法`都无法获取异常信息
@FeignClient(value = "album-provider",
//    fallback = CircuitFallbackFeignServiceFallback.class,
  fallbackFactory = CircuitFallbackFeignServiceFallbackFactory.class)
public interface CircuitFallbackFeignService {

  @RequestMapping("/album/server-port")
  String getServerPort();
}

/*
该类提供发生异常时的补偿方法
必须要有 @Component ， 可以是外部类
 */
/*
@Component
弃用，存在无法获取异常信息的弊端
*/
class CircuitFallbackFeignServiceFallback implements CircuitFallbackFeignService {
  @Override
  public String getServerPort() {
    return "feign method getServerPort occur hystrix fallback";
  }
}

@Component
class CircuitFallbackFeignServiceFallbackFactory implements FallbackFactory<CircuitFallbackFeignService> {

  // 原方法异常时，调用该方法
  @Override
  public CircuitFallbackFeignService create(Throwable throwable) {
    return new CircuitFallbackFeignService() {

      @Override
      public String getServerPort() {
        String exMsg = throwable.getMessage();
        return "feign method getServerPort occur hystrix fallback, exception is " + exMsg;
      }
    };
  }
}