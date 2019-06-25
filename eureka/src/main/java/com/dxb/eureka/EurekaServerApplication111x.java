package com.dxb.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication111x {
    public static void main(String args[]) {
        SpringApplication.run(EurekaServerApplication111x.class, args);
    }
}
