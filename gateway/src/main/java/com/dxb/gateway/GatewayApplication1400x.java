package com.dxb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication1400x {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication1400x.class, args);
    }
}
