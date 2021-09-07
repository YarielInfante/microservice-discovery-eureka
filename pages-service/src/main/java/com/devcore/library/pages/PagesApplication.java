package com.devcore.library.pages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagesApplication.class, args);
    }
}
