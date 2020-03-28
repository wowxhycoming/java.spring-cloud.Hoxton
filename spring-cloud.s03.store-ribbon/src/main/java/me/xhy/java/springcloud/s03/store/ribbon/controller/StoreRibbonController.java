package me.xhy.java.springcloud.s03.store.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/store-ribbon")
public class StoreRibbonController {

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/album-provider-port")
  public String getProviderPort() {
    return restTemplate.getForObject("http://album-provider/album/server-port", String.class);
  }
}
