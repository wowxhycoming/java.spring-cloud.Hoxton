package me.xhy.java.springcloud.s04.store.feign.controller;

import me.xhy.java.springcloud.s04.store.feign.StoreFeign;
import me.xhy.java.springcloud.s04.store.feign.service.StoreFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store-feign")
public class StoreFeignController {

  @Autowired
  StoreFeignService storeFeignService;

  @RequestMapping("/album-provider-port")
  public String getProviderPort() {
    return storeFeignService.getProviderPort();
  }
}
