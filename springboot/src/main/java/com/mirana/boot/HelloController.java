package com.mirana.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController 返回的是json数据，想要返回视图，则必须定义为@controller
@Controller
public class HelloController {


    // 注入application.yml的属性
    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private int age;

    // 返回视图
    @RequestMapping("/myindex")
    public String myindex() {
        return "myindex.html";
    }

    // 相应数据
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello SpringBoot";
    }

    @RequestMapping("/getPerson")
    @ResponseBody
    public String getPerson() {
        return String.format("name: %s, age: %d", name, age);
    }
}
