package com.mirana.feigncustomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;


    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/getServices")
    public String getServices() {
        String services = customerService.getServices();
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