package com.dxb.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Environment environment;
    @Value("${server.port}")
    private String ip;

    @GetMapping("/client")
    public String client() {
        String services = "Services: " + discoveryClient.getServices() + " ip :" + ip;
        System.out.println(services + ip.equals(environment.getProperty("server.port")));
        return services;
    }

    @GetMapping("/add")
    public int add(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        Integer r = a + b;
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
}