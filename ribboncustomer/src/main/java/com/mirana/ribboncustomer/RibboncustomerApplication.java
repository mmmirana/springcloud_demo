package com.mirana.ribboncustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// 测试过程中返现，使用 @EnableEurekaClient 和 @EnableDiscoveryClient 其中一个就可以，之前只能使用@EnableEurekaClient
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
// 测试断路器
@EnableHystrix
public class RibboncustomerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibboncustomerApplication.class, args);
    }
}
