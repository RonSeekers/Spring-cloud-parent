package com.ron.seekers.spring.cloud.service;

import com.ron.seekers.spring.cloud.entity.UserDto;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {

    @Override
    public UserDto findById(int id) {
        UserDto userDto=new UserDto();
        userDto.setId(0);
        return userDto;
    }
}
