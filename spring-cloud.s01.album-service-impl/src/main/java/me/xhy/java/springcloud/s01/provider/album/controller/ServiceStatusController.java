package me.xhy.java.springcloud.s01.provider.album.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class ServiceStatusController {

  // 期望的服务状态，默认是 true ，也就是服务状态为 UP
  public static boolean expectedStatus = true;

  @RequestMapping("/status")
  public String getServiceStatus() {
    return "期望的服务状态是 ： "
        + expectedStatus
        + " ，等待 spring cloud 同步该状态，查看 eureka ui 面板信息";
  }

  /*
   * 该接口接收一个 boolean 值，使用这个值来模拟检查 DB 是否可用后的返回结果
   *（DB 是不是可用，这个接口传值说的算）
   */
  @RequestMapping("/status/{isUp}")
  public String setServiceStatus(@PathVariable boolean isUp) {
    expectedStatus = isUp;
    return "期望的服务状态是 ： "
        + expectedStatus
        + " ，等待 spring cloud 同步该状态，查看 eureka ui 面板信息";
  }
}
