package me.xhy.java.springcloud.s01.provider.album.health;

import me.xhy.java.springcloud.s01.provider.album.controller.ServiceStatusController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class HealthSelfCheckService implements HealthIndicator {

  /*
   * 这里的逻辑应该是有个定时任务，周期性的检查 DB 的链接状态，改变 ServiceStatusController.expectedStatus 的值
   * 当 health() 被调用时，根据当时的情况返回服务状态。
   * 当然表示状态的变量不应该在 Controller 里
   */
  @Override
  public Health health() {
    if(ServiceStatusController.expectedStatus) {
      return new Health.Builder(Status.UP).build();
    } else {
      return new Health.Builder(Status.DOWN).build();
    }
  }
}
