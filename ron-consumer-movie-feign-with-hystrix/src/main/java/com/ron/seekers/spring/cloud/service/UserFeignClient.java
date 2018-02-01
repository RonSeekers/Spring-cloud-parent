package com.ron.seekers.spring.cloud.service;

import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="ron-provicer-user" ,fallback =HystrixClientFallback.class )
public interface  UserFeignClient{

    @RequestMapping(value = "/simple/{id}" ,method = RequestMethod.GET)
    public UserDto findById(@PathVariable("id") int id) ;

}
