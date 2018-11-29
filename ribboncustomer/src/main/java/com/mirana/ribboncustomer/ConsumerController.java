package com.mirana.ribboncustomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/getServices")
    public String getServices() {
        String services = restTemplate.getForObject("http://eurekaclient/getServices", String.class);
        return services;
    }


    @GetMapping("/log-instance")
    public String logUserInstance() {
        // 服务提供商实例信息
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eurekaclient");

        String serviceInfo = String.format("%s:%s:%s", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        // 打印当前选择的是哪个节点
        LOGGER.info(serviceInfo);

        return serviceInfo;
    }
}
