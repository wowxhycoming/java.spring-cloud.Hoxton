package me.xhy.java.springcloud.s05.hystrix.circuitfallback.controller;

import me.xhy.java.springcloud.s05.hystrix.circuitfallback.service.CircuitFallbackFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class CircuitFallbackFeignController {

  @Autowired
  CircuitFallbackFeignService service;

  @RequestMapping("/cf/feign")
  public String getServerPort() {
    return service.getServerPort();
  }
}
