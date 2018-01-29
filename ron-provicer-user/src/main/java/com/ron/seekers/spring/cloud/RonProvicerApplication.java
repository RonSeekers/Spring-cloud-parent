package com.ron.seekers.spring.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RonProvicerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RonProvicerApplication.class, args);
	}
}
