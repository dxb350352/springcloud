package com.dxb.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ComputeClient computeClient;

    @GetMapping("/add")
    public int add(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return computeClient.add(a, b);
    }

}
