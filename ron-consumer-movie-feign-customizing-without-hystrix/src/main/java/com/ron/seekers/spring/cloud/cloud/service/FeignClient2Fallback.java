package com.ron.seekers.spring.cloud.cloud.service;

public class FeignClient2Fallback  implements FeignClient{
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {

        return "haha";
    }
}
