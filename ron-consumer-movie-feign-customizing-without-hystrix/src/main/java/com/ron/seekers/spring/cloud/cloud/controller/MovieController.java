package com.ron.seekers.spring.cloud.cloud.controller;

import com.ron.seekers.spring.cloud.cloud.entity.UserDto;
import com.ron.seekers.spring.cloud.cloud.service.FeignClient;
import com.ron.seekers.spring.cloud.cloud.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    UserFeignClient userFeignClient;

    @Autowired
    FeignClient feignClient;
    @GetMapping("/movie/{id}")
    public UserDto findById(@PathVariable int id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/{servicename}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String servicename){
        return this.feignClient.findServiceInfoFromEurekaByServiceName(servicename);
    }
}
