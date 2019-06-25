package com.dxb.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@RestController
//启动consul：consul agent -dev -bind=192.168.130.225
//http://localhost:8500
public class ConsulClientApplication1000x {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication1000x.class, args);

    }

    @RequestMapping("/hi")
    public String home() {
        return "hello";
    }


}
