package com.ron.seekers.spring.cloud.service;

import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="ron-provicer-user")
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}" ,method = RequestMethod.GET)
    public UserDto findById(@PathVariable("id") int id) ;

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public UserDto postUser(@RequestBody UserDto userDto);

    @RequestMapping(value ="/get",method = RequestMethod.GET)
    public UserDto getUser(UserDto userDto);
}
