package com.dxb.stream.controller;

import com.dxb.stream.component.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("send")
    public void send(String msg) {
        streamClient.output().send(MessageBuilder.withPayload(msg).build());
    }
}
