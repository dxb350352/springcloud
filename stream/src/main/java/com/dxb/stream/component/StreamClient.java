package com.dxb.stream.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String INPUT = "myInput";
    String OUTPUT = "myOutput";


    /**
     * Input默认使用方法名作为消息通道的名称
     */
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    /**
     * Output默认使用方法名作为消息通道的名称
     */
    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}