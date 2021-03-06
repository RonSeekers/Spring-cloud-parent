package com.ron.seekers.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack",commandProperties = {@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
    public UserDto findById(@PathVariable int id) {
        // http://localhost:7900/simple/
        // VIP virtual IP
        // HAProxy Heartbeat
        return this.restTemplate.getForObject("http://ron-provider-user/simple/" + id, UserDto.class);
    }

    public UserDto findByIdFallBack(int id) {
        UserDto userDto = new UserDto();
        userDto.setId(0);
        return userDto;
    }
}
