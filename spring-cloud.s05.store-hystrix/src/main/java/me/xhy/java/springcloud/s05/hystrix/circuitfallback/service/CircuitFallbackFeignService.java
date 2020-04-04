package me.xhy.java.springcloud.s05.hystrix.circuitfallback.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "album-provider", fallback = CircuitFallbackFeignServiceFallback.class)
public interface CircuitFallbackFeignService {

  @RequestMapping("/album/server-port")
  String getServerPort();

}

/*
该类提供发生异常时的补偿方法
必须要有 @Component ， 可以是外部类
 */
@Component
class CircuitFallbackFeignServiceFallback implements CircuitFallbackFeignService {
  @Override
  public String getServerPort() {
    return "feign method getServerPort occur hystrix fallback";
  }
}