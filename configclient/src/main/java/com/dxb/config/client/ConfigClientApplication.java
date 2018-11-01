package com.dxb.config.client;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ConfigClientApplication {
    public static void main(String args[]) {
        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
