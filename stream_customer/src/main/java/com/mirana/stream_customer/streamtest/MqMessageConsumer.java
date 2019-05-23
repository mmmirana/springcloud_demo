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
        // 刚刚我断开了，应该还可以继续重试，现在看看还在不在消息队列
        // 这样，先看看刚刚的队列还在不在，生产者的队列在，消费者不知道有没有队列（应该没有）
//        有的，试试那个是正常的，说明这里接受消息的队列是消费者端注册的队列 - 5rKkmfI_T8G8tc30hSrYEw
//        我现在发送一个需要重试的消息，看看5rKkmfI_T8G8tc30hSrYEw这个队列是不是会被删除（应该会的，那消息肯定也会丢失）
        // 确实自动删除了，那消息也就肯定不在了。现在我重启会自动创建一个新的队列，不会受到之前的消息
// 没有受到，还有啥问题吗？
//        没了，代码发我一份呗，哈哈
//        我传到git，给你url
    }

}