package com.ron.seekers.spring.cloud.controller;

import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public UserDto findById(@PathVariable int id) {
        return this.restTemplate.getForObject("http://localhost:8001/simple/" + id, UserDto.class);
    }
}
