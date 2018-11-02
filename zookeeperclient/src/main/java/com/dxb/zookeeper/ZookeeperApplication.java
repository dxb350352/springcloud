package com.dxb.zookeeper;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@RestController
public class ZookeeperApplication {
    public static void main(String args[]) {
        new SpringApplicationBuilder(ZookeeperApplication.class).web(true).run(args);
    }

    @GetMapping
    public String hi() {
        return "hello zz";
    }
}
