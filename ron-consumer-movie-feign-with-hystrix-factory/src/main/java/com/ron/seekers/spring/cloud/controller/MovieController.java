package com.ron.seekers.spring.cloud.controller;

import com.ron.seekers.spring.cloud.entity.UserDto;
import com.ron.seekers.spring.cloud.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public UserDto findById(@PathVariable int id) {
        return this.userFeignClient.findById(id);
    }


}
