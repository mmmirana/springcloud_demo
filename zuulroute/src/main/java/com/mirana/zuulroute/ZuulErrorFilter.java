package com.mirana.zuulroute;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZuulErrorFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ZuulErrorFilter.class);

    @Override
    public String filterType() {
        logger.info(this.getClass().getSimpleName() + ": filterType");
        return "error";
    }

    @Override
    public int filterOrder() {
        logger.info(this.getClass().getSimpleName() + ": filterOrder");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        logger.info(this.getClass().getSimpleName() + ": shouldFilter");
        // true代表过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info(this.getClass().getSimpleName() + ": run");
        return null;
    }
}
