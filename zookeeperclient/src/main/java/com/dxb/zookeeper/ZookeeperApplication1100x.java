package com.dxb.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@RestController
public class ZookeeperApplication1100x {
    public static void main(String args[]) {
        SpringApplication.run(ZookeeperApplication1100x.class, args);
    }

    @GetMapping
    public String hi() {
        return "hello zz";
    }
}
