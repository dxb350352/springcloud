package com.dxb.consul;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@RestController
//启动consul：consul agent -dev -bind=192.168.130.225
public class ConsulClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulClientApplication.class).web(true).run(args);
    }

    @RequestMapping("/hi")
    public String home() {
        return "hello";
    }


}
