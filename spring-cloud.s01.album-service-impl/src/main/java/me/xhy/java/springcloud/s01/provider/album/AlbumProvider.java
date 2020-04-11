package me.xhy.java.springcloud.s01.provider.album;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AlbumProvider {
  public static void main(String[] args) {
    SpringApplication.run(AlbumProvider.class, args);
  }

//  @Bean
//  public ServletRegistrationBean getServlet(){
//    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();    //监控实例
//    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);    //servlet注册接口
//    registrationBean.setLoadOnStartup(1);
//    registrationBean.addUrlMappings("/actuator/hystrix.stream");
//    registrationBean.setName("HystrixMetricsStreamServlet");
//    return registrationBean;
//  }

}
