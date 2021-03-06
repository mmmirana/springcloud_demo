package com.mirana.stream.streamtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StreamController {

    @Autowired
    private MqMessageProducer producer;

    /**
     * 模拟生产者发送消息
     *
     * @param message 消息
     * @param type    type==100 正常消费，非100，抛出异常
     * @return
     */
    @GetMapping("/send")
    public String send(String message, String type) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("type", type);
        MessageHeaders headers = new MessageHeaders(headerMap);

        producer.sendMsg(MessageBuilder.createMessage(message, headers));

        return "成功发送一条信息：" + message;
    }
}
