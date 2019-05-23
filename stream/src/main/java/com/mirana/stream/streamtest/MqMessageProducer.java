package com.mirana.stream.streamtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Slf4j
@EnableBinding(MyProcessor.class)
public class MqMessageProducer {

    @Autowired
    @Output(MyProcessor.STREAM_OUTPUT)
    private MessageChannel channel;

    public void sendMsg(Message msg) {
        channel.send(msg);
        log.info("消息发送成功：{}", msg.getPayload().toString());
    }
}