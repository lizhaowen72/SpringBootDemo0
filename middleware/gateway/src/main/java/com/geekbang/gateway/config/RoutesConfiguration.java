package com.geekbang.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator declare(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route
                        .path("/gateway/coupon-customer")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://coupon-customer-serv")
                ).route(route -> route
                        .order(1)
                        .path("/gateway/template/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://coupon-template-serv"))
                .route(route -> route
                        .path("/gateway/calculator/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://coupon-calculation-serv"))
                .build();
    }
}
