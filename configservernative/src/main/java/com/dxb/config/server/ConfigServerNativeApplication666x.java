package com.dxb.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringCloudApplication
@EnableConfigServer
//http://localhost:6661/config-client-pro.properties
//刷新所有配置
//POST http://localhost:6661/actuator/bus-refresh
public class ConfigServerNativeApplication666x {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerNativeApplication666x.class, args);
    }
}
