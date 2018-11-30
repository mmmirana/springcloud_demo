package com.mirana.zuulroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulrouteApplication {
    
    //  正常请求日志
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: filterType
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: run
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: filterType
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: filterType
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: run
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: filterType
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: filterType
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: run
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: filterType

    //  停掉某台服务器，再次请求时
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: filterType
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: run
    //  com.mirana.zuulroute.ZuulPreFilter       : ZuulPreFilter: filterType
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: filterType
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: run
    //  com.mirana.zuulroute.ZuulRouteFilter     : ZuulRouteFilter: filterType
    //  com.mirana.zuulroute.ZuulErrorFilter     : ZuulErrorFilter: filterType
    //  com.mirana.zuulroute.ZuulErrorFilter     : ZuulErrorFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulErrorFilter     : ZuulErrorFilter: run
    //  com.mirana.zuulroute.ZuulErrorFilter     : ZuulErrorFilter: filterType
    //  o.s.c.n.z.filters.post.SendErrorFilter   : Error during filtering
    //  --------------
    //  -- ErrorMsg --
    //  --------------
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: filterType
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: shouldFilter
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: run
    //  com.mirana.zuulroute.ZuulPostFilter      : ZuulPostFilter: filterType

    public static void main(String[] args) {
        SpringApplication.run(ZuulrouteApplication.class, args);
    }
}
