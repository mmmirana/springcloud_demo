package com.mirana.feigncustomer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eurekaclient", fallbackFactory = CustomerServiceImpl.class)
public interface ICustomerService {

    // 这里对应的是服务提供者的url
    @GetMapping(value = "/getServices")
    String getServices();
}