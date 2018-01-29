package com.ron.seekers.spring.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ron.seekers.spring.cloud.Dao.UserDao;
import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    public UserDto findById(@PathVariable int id) {
        return this.userDao.findOne(id);
    }


    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("RON-PROVICER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/localhost-info")
    public ServiceInstance showInfo() {
        ServiceInstance serviceInstance = this.discoveryClient.getLocalServiceInstance();
        return serviceInstance;
    }

    @PostMapping("/user")
    public UserDto postUser(@RequestBody UserDto userDto) {
        return userDto;
    }

    @GetMapping("/get-user")
    public UserDto getUser(UserDto userDto) {
        return userDto;
    }
}
