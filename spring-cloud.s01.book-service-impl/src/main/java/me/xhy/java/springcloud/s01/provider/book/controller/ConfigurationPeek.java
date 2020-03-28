package me.xhy.java.springcloud.s01.provider.book.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RefreshScope 当使用 /actuator/refresh 同步配置文件时，可以让发生变化的值赋值到该类的属性中
 * /actuator/refresh 是 spring-boot-starter-actuator 包的功能
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigurationPeek {

  @Value("${info.version:null}")
  private String version;


  @RequestMapping("/version")
  public String version() {
    return version;
  }
}
