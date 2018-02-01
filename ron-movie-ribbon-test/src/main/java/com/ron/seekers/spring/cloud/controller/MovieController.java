package com.ron.seekers.spring.cloud.controller;

import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public UserDto findById(@PathVariable Long id) {
        // http://localhost:7900/simple/
        // VIP virtual IP
        // HAProxy Heartbeat
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, UserDto.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

        return "1";
    }

    @GetMapping("/list-all")
    public List<UserDto> listAll() {
        List<UserDto> list = this.restTemplate.getForObject("http://ron-provider-user/list-all", List.class);

        for (UserDto userDto : list) {
            System.out.println(userDto.getUsername());
            System.out.println(userDto.getId());
        }


        UserDto[] userDtos = this.restTemplate.getForObject("http://ron-provider-user/list-all", UserDto[].class);
        List<UserDto> list1 = Arrays.asList(userDtos);
        return list1;
    }
}
