package com.dxb.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//非重启项目手动刷新配置注解
public class TestController {
    @Value("${config.test}")
    private String configInfo;

    @GetMapping("/config")
    public String getConfigInfo() {
        return configInfo;
    }
}
