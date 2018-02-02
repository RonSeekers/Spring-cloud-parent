package com.ron.seekers.spring.cloud.service;

import com.ron.seekers.spring.cloud.entity.UserDto;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
    @Override
    public UserFeignClient create(Throwable throwable) {
        logger.info("fallback; reason was: " + throwable.getMessage());
        return new  HystrixClientWithFallBackFactory(){

            @Override
            public UserDto findById(int id) {

                UserDto userDto =new UserDto();
                userDto.setId(-1);
                return userDto;
            }
        };
    }
}
