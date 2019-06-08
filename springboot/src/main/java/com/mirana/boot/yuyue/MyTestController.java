package com.mirana.boot.yuyue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MyTestController {
    @Autowired
    private MyServiceImpl myService;

    /**
     * 开启两个线程
     *
     * @return
     */
    @GetMapping("startAsyncThread")
    public String startAsyncThread() {
        AsyncProcessor.startAsyncThread();
        return "startAsyncThread success";
    }


    /**
     * 预约请求
     *
     * @return
     */
    @GetMapping("yuyue")
    public String yuyue() {
        String phone = System.currentTimeMillis() + "";
        return myService.yuyue(phone);
    }
}
