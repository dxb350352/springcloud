package com.dxb.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringCloudApplication
@EnableConfigServer
//刷新所有配置
//POST http://localhost:6661/actuator/bus-refresh
public class ConfigServerApplication666x {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication666x.class, args);
    }
}
