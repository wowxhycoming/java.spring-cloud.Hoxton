package me.xhy.java.springcloud.s07.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*
@EnableTurbine 开启 Turbine 功能
 */
@SpringBootApplication
@EnableTurbine
public class Turbine {
  public static void main(String[] args) {
    SpringApplication.run(Turbine.class, args);
  }
}