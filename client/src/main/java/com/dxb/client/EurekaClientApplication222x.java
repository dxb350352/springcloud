package com.dxb.client;

import com.dxb.client.controller.DiscoveryController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
/**
 * 创建提供服务的客户端，并向服务注册中心注册自己。
 */
public class EurekaClientApplication222x {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new SpringApplicationBuilder(EurekaClientApplication222x.class)
                .web(true).run(args);
        //获取配置文件信息
        System.out.println(ctx.getEnvironment().getProperty("active.port"));
        //获取bean
        DiscoveryController dc = ctx.getBean("discoveryController", DiscoveryController.class);
        dc.client();
    }
}