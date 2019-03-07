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

    // 当服务提供商停止某服务，但是服务注册中心尚未移除已停止的服务时，启用服务降级策略。超时/出现异常也会启用服务降级策略。
    @HystrixCommand(fallbackMethod = "getServicesErr")
    @GetMapping("/customer/getServices")
    public String getServices() {
        LOGGER.info("routing - ribboncustomer...");
        String services = restTemplate.getForObject("http://eurekaclient/getServices", String.class);
        return "ribboncustomer: " + services;
    }

    public String getServicesErr() {
        LOGGER.info("getServicesErr：" + logUserInstance());
        return "From Hystrix: getServicesErr!!!";
    }


    /**
     * 打印负载均衡的服务提供者实例，日志如下：
     * eurekaclient:localhost:9001
     * eurekaclient:localhost:9002
     * eurekaclient:localhost:9001
     * eurekaclient:localhost:9002
     * ......
     *
     * @return 服务提供者的实例ID，ip，端口
     */
    @GetMapping("/log-instance")
    public String logUserInstance() {
        // 服务提供商实例信息
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eurekaclient");
        if (serviceInstance != null) {
            String serviceInfo = String.format("%s:%s:%s", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
            // 打印当前选择的是哪个节点
            LOGGER.info(serviceInfo);
            return serviceInfo;
        } else {
            return "serviceInstance is null";
        }
    }
}
