package com.ron.seekers.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class TurbineApplication3 {
  public static void main(String[] args) {
    SpringApplication.run(TurbineApplication3.class, args);
  }
}
