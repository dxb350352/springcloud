package com.dxb.feign.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
    @GetMapping("/add")
    int add(@RequestParam(defaultValue = "0", value = "a") int a, @RequestParam(defaultValue = "0", value = "b") int b);
}
