package com.dxb.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Registration registration;
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
        Integer r = a + b;
        System.out.println("/add, port:" + registration.getPort() + ", service_id:" + registration.getServiceId() + ", result:" + r);
        return r;
    }
}