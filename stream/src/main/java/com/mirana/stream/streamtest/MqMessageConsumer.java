package com.mirana.stream.streamtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.util.Random;

// 把消费者移动到那个项目里
//@Slf4j
//@EnableBinding(MyProcessor.class)
public class MqMessageConsumer {
//
//    /**
//     * 当headers中的消息为100时，正常消费
//     *
//     * @param msg
//     */
//    @StreamListener(target = MyProcessor.STREAM_INPUT, condition = "headers['type']=='100'")
//    public void messageInPutSuccess(Message msg) {
//        long randomSec = new Random().nextInt(6);
//        try {
//            long randomMillSeconds = randomSec * 1000;
//            log.info("模拟延时，randomSec: {}", randomSec);
//            Thread.sleep(randomMillSeconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("{}, 消息接收成功：{}", DateUtils.format(), msg.getPayload().toString());
//    }
//
//    /**
//     * 当headers中的消息不为100时，模拟消费异常并丢弃
//     *
//     * @param msg
//     */
//    @StreamListener(target = MyProcessor.STREAM_INPUT, condition = "headers['type']!='100'")
//    public void messageInPutError(Message msg) {
//        log.info("{}, 消息接收成功：{}", DateUtils.format(), msg.getPayload().toString());
//        // 模拟异常，当消息超过retry.max-attempts次数，将会自动丢弃
//        throw new RuntimeException("模拟异常");
//    }

}