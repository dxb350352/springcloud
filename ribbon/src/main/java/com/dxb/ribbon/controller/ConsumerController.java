package com.dxb.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ComputeService computeService;

    @GetMapping("/add")
    public String add(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return restTemplate.getForEntity("http://eureka-client/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public String add2() {
        return computeService.addService();
    }
}
