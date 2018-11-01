package com.dxb.feign.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public int add(@RequestParam(defaultValue = "0", value = "a") int a, @RequestParam(defaultValue = "0", value = "b") int b) {
        return -9999;
    }

}
