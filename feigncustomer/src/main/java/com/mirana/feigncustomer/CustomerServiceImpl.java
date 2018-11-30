package com.mirana.feigncustomer;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements FallbackFactory<ICustomerService> {
    @Override
    public ICustomerService create(Throwable throwable) {
        return () -> "FromHystrix-feigncustomer-err !!!";
    }
}
