package com.mirana.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
    @Autowired
    private  MyServiceImpl myService;

    @GetMapping("yuyue")
    public String yuyue(String phone){
        return myService.yuyue(phone);
    }
}
