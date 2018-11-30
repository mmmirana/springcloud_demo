package com.mirana.feigncustomer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eurekaclient")
public interface CustomerService {

    @GetMapping(value = "/getServices")
    String getServices();
}