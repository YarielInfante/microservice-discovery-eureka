package com.devcore.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.devcore.service.api.reviews", "com.devcore.apigateway"})
public class ApiGatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
