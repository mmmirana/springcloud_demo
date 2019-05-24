package com.mirana.stream_customer.streamtest;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {

    String STREAM_INPUT = "stream_input";

    /**
     * 消费者通道
     *
     * @return
     */
    @Input(STREAM_INPUT)
    SubscribableChannel input();

}
