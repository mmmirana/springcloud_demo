package com.mirana.stream_customer.streamtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(MyProcessor.class)
public class MqMessageConsumer {

    /**
     * 当headers中的消息为100时，正常消费
     *
     * @param msg
     */
    @StreamListener(target = MyProcessor.STREAM_INPUT, condition = "headers['type']=='100'")
    public void messageInPutSuccess(Message msg) {
        log.info("{}, 消息接收成功：{}", DateUtils.format(), msg.getPayload().toString());
    }

    /**
     * 当headers中的消息不为100时，模拟消费异常并丢弃
     *
     * @param msg
     */
    @StreamListener(target = MyProcessor.STREAM_INPUT, condition = "headers['type']!='100'")
    public void messageInPutError(Message msg) {
        log.info("{}, 消息接收成功：{}", DateUtils.format(), msg.getPayload().toString());
        // 模拟异常，当消息超过retry.max-attempts次数，将会自动丢弃
        throw new RuntimeException("模拟异常");
    }

}