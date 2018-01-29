package controller;

import entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/movie/{id}")
    public UserDto findById(@PathVariable int id) {
        ServiceInstance serviceInstance= this.loadBalancerClient.choose("ron-provicer-user");
        System.out.println("1:::"+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());
        return this.restTemplate.getForObject("http://ron-provicer-user/simple/" + id, UserDto.class);
    }


    @GetMapping("/get")
    public String get() {
        ServiceInstance serviceInstance= this.loadBalancerClient.choose("ron-provicer-user");
        System.out.println("1:::"+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());


        ServiceInstance serviceInstance2= this.loadBalancerClient.choose("ron-provicer-user2");
        System.out.println("2:::"+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+serviceInstance2.getServiceId());
        return "1";
    }
}
