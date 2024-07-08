package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth_service", r -> r.path("/auth/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c.setName("authCircuitBreaker")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("lb://AUTH-SERVICE"))
                .route("user_service", r -> r.path("/user/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("lb://USER-MANAGEMENT"))
                .route("tweet_service", r -> r.path("/tweets/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c.setName("tweetCircuitBreaker")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("lb://TWEETS"))
                .build();
    }
}

