package com.dxb.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminClientApplication1700x {
    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication1700x.class, args);
    }
}
