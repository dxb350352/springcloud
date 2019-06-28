package com.dxb.agoodprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AGoodProviderApplication1800x {
    public static void main(String[] args) {
        SpringApplication.run(AGoodProviderApplication1800x.class, args);
    }
}
