package com.ron.seekers.spring.cloud.controller;

import com.google.common.collect.Lists;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ron.seekers.spring.cloud.Dao.UserDao;
import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping("/list-all")
    public List<UserDto> listAll(){
        ArrayList<UserDto> list = Lists.newArrayList();
        UserDto userDto=new UserDto(1,"张三");
        UserDto userDto2=new UserDto(1,"张三");
        UserDto userDto3=new UserDto(1,"张三");
        UserDto userDto4=new UserDto(1,"张三");

        list.add(userDto);
        list.add(userDto2);
        list.add(userDto3);
        return list;
    }
}
