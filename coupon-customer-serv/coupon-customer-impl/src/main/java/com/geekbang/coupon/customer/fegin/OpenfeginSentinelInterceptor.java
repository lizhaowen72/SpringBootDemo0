package com.geekbang.coupon.customer.fegin;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenfeginSentinelInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("SentinelSource","coupon-customer-serv");
    }
}
