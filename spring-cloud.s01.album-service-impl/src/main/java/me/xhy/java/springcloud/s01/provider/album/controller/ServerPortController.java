package me.xhy.java.springcloud.s01.provider.album.controller;

import me.xhy.java.springcloud.s01.provider.album.config.ServerPortConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/album")
public class ServerPortController {

  @Autowired
  ServerPortConfiguration serverPortConfiguration;

  @RequestMapping("server-port")
  public String serverPort() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "this is album service running on port " + serverPortConfiguration.getPort();
  }
}
