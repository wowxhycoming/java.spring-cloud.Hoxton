package me.xhy.java.springcloud.s05.hystrix.circuitfallback.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hystrix")
public class CircuitFallbackController {

  @Autowired
  RestTemplate restTemplate;

  /*
  新增了 @HystrixCommand
  @HystrixCommand(fallbackMethod = "getMoviesError") 默认键为 fallbackMethod
  表示当调用 provider 失败，调用的补偿方法
  默认情况下，发生3次错误（补偿方法调用了3次），该 provider 将被熔断
  当被熔断的 provider 重新上线，将被重新加回到服务列表
  */
  @RequestMapping("/cf/ribbon")
  @HystrixCommand(fallbackMethod = "getServerPortError")
  public String getServerPort() {
    return restTemplate.getForObject("http://album-provider/album/server-port", String.class);
  }

  public String getServerPortError() {
    return "ribbon method getMovies occur hystrix";
  }

  @RequestMapping("/cf/always-exception")
  @HystrixCommand(fallbackMethod = "getServerPortError")
  public String alwaysException() {
    if(true) throw new RuntimeException();
    return "hi";
  }
}
