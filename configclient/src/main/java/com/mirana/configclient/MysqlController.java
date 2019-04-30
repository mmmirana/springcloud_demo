package com.mirana.configclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class MysqlController {
    @Value("${mysql.host}")
    private String host;

    @Value("${mysql.port}")
    private String port;

    @Value("${mysql.username}")
    private String username;

    @Value("${mysql.password}")
    private String password;


    /**
     * 从SpringCloud ConfigServer 获取Mysql配置
     * 访问 http://localhost:9031/getMysqlConfig，返回数据如下：
     * {"password":"1234","port":"3306","host":"loaclhost","username":"root"}
     *
     * @return mysqlConfigJson
     */
    @GetMapping("/getMysqlConfig")
    public String getMysqlConfig() {
        Map<String, Object> mysqlmap = new HashMap<>();
        mysqlmap.put("host", host);
        mysqlmap.put("port", port);
        mysqlmap.put("username", username);
        mysqlmap.put("password", password);

        String mysqlConfigJson = null;
        try {
            mysqlConfigJson = new ObjectMapper().writeValueAsString(mysqlmap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return mysqlConfigJson;
    }
}
