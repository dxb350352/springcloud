package com.dxb.turbine.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {


    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiErr")
    public String hi(@RequestParam String name) {
        if (System.currentTimeMillis() % 2 == 0) {
            int i = 1 / 0;
        }
        return "hi," + name + ",I am a port:" + port;
    }

    public String hiErr(@RequestParam String name) {
        return "sorry," + name + ",have a error";
    }
}
