package me.xhy.java.springcloud.s02.eureka.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(HttpSecurity http) throws Exception {
    // 关闭 csrf
    http.csrf().disable();
    // 开启认证， URL 格式登录时，需要为 httpBasic
    http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
  }
}
