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
     * 20190430
     * 1、更新配置文件password 1234->5678
     * 2、POST 访问地址 http://localhost:9031/actuator/bus-refresh
     *      这里使用MINGW64提交Post请求
     *      Assassin@mirana MINGW64 ~
     *      $ curl -v -X POST "http://localhost:9031/actuator/bus-refresh"
     *        % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
     *                                       Dload  Upload   Total   Spent    Left  Speed
     *        0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0*   Trying ::1...
     *      * TCP_NODELAY set
     *      * Connected to localhost (::1) port 9031 (#0)
     *      > POST /actuator/bus-refresh HTTP/1.1
     *      > Host: localhost:9031
     *      > User-Agent: curl/7.60.0
     *      > Accept: ...
     *      >0     0    0     0    0     0      0      0 --:--:--  0:00:14 --:--:--     0< HTTP/1.1 204
     *      < Date: Tue, 30 Apr 2019 08:07:20 GMT
     *      <
     *        0     0    0     0    0     0      0      0 --:--:--  0:00:14 --:--:--     0
     *      * Connection #0 to host localhost left intact
     * 3、重新访问 http://localhost:9031/getMysqlConfig，返回数据如下：
     * {"password":"5678","port":"3306","host":"loaclhost","username":"root"}
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
