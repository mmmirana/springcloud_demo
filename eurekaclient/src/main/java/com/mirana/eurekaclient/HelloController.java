package com.mirana.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello, this is eurekaclient";
    }

    @GetMapping("/getServices")
    public String getServices() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
