package me.xhy.java.springcloud.s03.store.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import me.xhy.java.springcloud.s03.store.ribbon.config.IgnoreScan;
import me.xhy.java.springcloud.s03.store.ribbon.config.RibbonPartialStrategyRoundRobin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
/*
@ComponentScan 应用 IgnoreScan ， 排除我们定义的局部负载均衡策略
@RibbonClient 针对 client 指定负载均衡策略。 name 是请求服务提供方的 ${spring.application.name}  ，configuration 是该客户端应用各种策略
 */
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = IgnoreScan.class))
@RibbonClient(name = "album-provider", configuration = RibbonPartialStrategyRoundRobin.class)
@EnableRetry
public class StoreRibbon {
  public static void main(String[] args) {
    SpringApplication.run(StoreRibbon.class, args);
  }

//  @Bean // 向 IOC 容器注入一个 bean，名字是 restTemplate
//  @LoadBalanced // restTemplate 开启负载均衡的功能
//  RestTemplate restTemplate() {
//    return new RestTemplate();
//  }

  @Bean
  @LoadBalanced
  RestTemplate restTemplate() {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setConnectTimeout(1);
    factory.setReadTimeout(1);
    return new RestTemplate(factory);
  }

  @Bean
  public IRule ribbonRule() {
    return new
        RandomRule() // 随机分配
        /*RoundRobinRule() // 轮询*/
        /*RetryRule() // 重试*/
        /*BestAvailableRule() // 最低并发*/
        /*AvailabilityFilteringRule() // 可用过滤*/
        /*ResponseTimeWeightedRule() // 响应时间加权*/
        /*ZoneAvoidanceRule() // 区域权衡*/
        ;
  }
}
