package com.mirana.ribboncustomer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    // 当服务提供商停止某服务，但是服务注册中心尚未移除已停止的服务时，启用服务降级策略。超时/出现异常也会qiyo9ng服务降级策略。
    @HystrixCommand(fallbackMethod = "getServicesErr")
    @GetMapping("/getServices")
    public String getServices() {
        String services = restTemplate.getForObject("http://eurekaclient/getServices", String.class);
        return services;
    }

    public String getServicesErr() {
        LOGGER.info("getServicesErr：" + logUserInstance());
        return "From Hystrix: getServicesErr!!!";
    }


    @GetMapping("/log-instance")
    public String logUserInstance() {
        // 服务提供商实例信息
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eurekaclient");

        String serviceInfo = String.format("%s:%s:%s", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());

        return serviceInfo;
    }
}
