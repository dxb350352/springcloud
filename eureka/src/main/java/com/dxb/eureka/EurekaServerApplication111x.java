package com.dxb.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication111x {
    public static void main(String args[]) {
        new SpringApplicationBuilder(EurekaServerApplication111x.class).web(true).run(args);
    }
}
