package com.mirana.boot.yuyue;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl {

    public String yuyue(String phone) {

        if (phone != null && phone.toString() != "") {
            YuyueData.phoneList.put(phone, 0);
        }

        return "yuyue success";
    }
}
