package com.ron.seekers.spring.cloud.cloud.service;

import com.ron.seekers.spring.cloud.cloud.entity.UserDto;
import com.ron.seekers.spring.cloud.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="ron-provicer-user",configuration = Configuration1.class ,fallback = HystrixClientFallback.class)
public interface UserFeignClient {

    @RequestLine("GET /simple/{id}")
    public UserDto findById(@Param("id") int id) ;

}
