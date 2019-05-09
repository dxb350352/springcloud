package com.dxb.stream.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @EnableBinding 注解用来指定一个或多个定义了 @Input 或 @Output 注解的接口，以此实现对消息通道（Channel）的绑定。
 */
@Component
//@EnableBinding(value = {org.springframework.cloud.stream.messaging.Processor.class})
@EnableBinding(value = {StreamClient.class})
public class StreamReceiver {

    private Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

    /**
     * @StreamListener，主要定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应了监听的消息通道名。
     */
    @StreamListener(StreamClient.INPUT)
    public void receive(String message) {
        logger.info("StreamReceiver: {}", message);
    }
}
