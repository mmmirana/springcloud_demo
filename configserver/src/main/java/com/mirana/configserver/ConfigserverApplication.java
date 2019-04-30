package com.mirana.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigserverApplication {

    // 映射规则：
    // 1、/{application}/{profile}[/{label}]
    // 2、/{application}-{profile}.properties
    // 3、/{label}/{application}-{profile}.properties
    // 4、/{application}-{profile}.yml
    // 5、/{label}/{application}-{profile}.yml

    // 规则1，测试properties
    // http://localhost:9030/mysqlprop/dev
    // {
    //	"name": "mysqlprop",
    //	"profiles": ["dev"],
    //	"label": null,
    //	"version": "63917abdf1d4937123a16fdc5925d05368a87514",
    //	"state": null,
    //	"propertySources": [{
    //		"name": "https://github.com/mmmirana/SpringcloudConfig.git/config_repo_dev/mysqlprop-dev.properties",
    //		"source": {
    //			"mysql.host": "loaclhost",
    //			"mysql.port": "3306",
    //			"mysql.username": "root",
    //			"mysql.password": "1234"
    //		}
    //	}]
    //}

    // 规则1，测试yml
    // http://localhost:9030/mysqlyml/dev
    // {
    //	"name": "mysqlyml",
    //	"profiles": ["dev"],
    //	"label": null,
    //	"version": "63917abdf1d4937123a16fdc5925d05368a87514",
    //	"state": null,
    //	"propertySources": [{
    //		"name": "https://github.com/mmmirana/SpringcloudConfig.git/config_repo_dev/mysqlyml-dev.yml",
    //		"source": {
    //			"mysql.host": "loaclhost",
    //			"mysql.port": 3306,
    //			"mysql.username": "root",
    //			"mysql.password": 1234
    //		}
    //	}]
    //}

    // 规则1，测试label
    // http://localhost:9030/mysqlyml/dev/master
    // {
    //	"name": "mysqlyml",
    //	"profiles": ["dev"],
    //	"label": "master",
    //	"version": "63917abdf1d4937123a16fdc5925d05368a87514",
    //	"state": null,
    //	"propertySources": [{
    //		"name": "https://github.com/mmmirana/SpringcloudConfig.git/config_repo_dev/mysqlyml-dev.yml",
    //		"source": {
    //			"mysql.host": "loaclhost",
    //			"mysql.port": 3306,
    //			"mysql.username": "root",
    //			"mysql.password": 1234
    //		}
    //	}]
    //}

    // 规则4，测试yml
    // http://localhost:9030/mysqlyml-dev.yml
    // mysql:
    //   host: loaclhost
    //   password: 1234
    //   port: 3306
    //   username: root

    // 规则5，测试yml+label
    // http://localhost:9030/master/mysqlyml-dev.yml
    // mysql:
    //   host: loaclhostt
    //   password: 1234
    //   port: 3306
    //   username: root

    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class, args);
    }
}
