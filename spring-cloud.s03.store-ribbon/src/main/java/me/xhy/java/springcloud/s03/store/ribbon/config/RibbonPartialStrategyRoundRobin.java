package me.xhy.java.springcloud.s03.store.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

@IgnoreScan
public class RibbonPartialStrategyRoundRobin {
  @Bean
  public IRule ribbonRule() {
    return new RoundRobinRule(); // 轮询
  }
}
