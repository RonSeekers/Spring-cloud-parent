package com.ron.seekers.spring.cloud.cloud.service;

import com.ron.seekers.spring.cloud.config.Configuration2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.cloud.netflix.feign.FeignClient(name="XXXX",url = "http://localhost:8761/",configuration = Configuration2.class ,fallback = FeignClient2Fallback.class)
public interface FeignClient {

@RequestMapping(value = "/eureka/apps/{servicename}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("servicename") String serviceName);
}
