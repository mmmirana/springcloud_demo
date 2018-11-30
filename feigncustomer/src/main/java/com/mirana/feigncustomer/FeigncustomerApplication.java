package com.mirana.feigncustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
@EnableFeignClients
// 开启Hystrix熔断
@EnableHystrix
public class FeigncustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeigncustomerApplication.class, args);
    }
}
