package com.ron.seekers.spring.cloud.controller;

import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  public UserDto findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://ron-provider-user/simple/" + id, UserDto.class);
  }

  public UserDto findByIdFallback(Long id) {
    UserDto user = new UserDto();
    user.setId(0L);
    return user;
  }
}
