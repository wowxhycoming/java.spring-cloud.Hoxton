package me.xhy.java.springcloud.s05.hystrix.isolation.controller;

import me.xhy.java.springcloud.s05.hystrix.isolation.service.IsolationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class IsolationController {

  @Autowired
  IsolationServiceImpl isolationServiceImpl;

  @RequestMapping("/isolation")
  public String isolationRequest() {
    return "";
  }
}
