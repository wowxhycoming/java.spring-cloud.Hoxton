package me.xhy.java.springcloud.s04.store.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
@FeignClient("") 参数填 Spring Cloud Provider 的应用名 ${spring.application.name}
 */
@FeignClient("album-provider")
public interface StoreFeignService {
  /*
  @RequestMapping() 默认参数是请求资源的地址，
  也可以指定请求的 Http Method @RequestMapping(value="/movie/movies",method=RequestMethod.GET)

  getMovies() 也可以算入参数，例如 getMovies(@RequestParam("name") String name) ，调用时比如传入的参数
   */
  @RequestMapping("/album/server-port")
  public String getProviderPort();
}
