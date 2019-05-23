package com.mirana.stream_customer.streamtest;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {

    String STREAM_OUTPUT = "stream_output";
    String STREAM_INPUT = "stream_input";
    String STREAM_DLQ = "stream_dlq";

    /**
     * 生产者通道
     *
     * @return
     */
    @Output(STREAM_OUTPUT)
    MessageChannel output();

    /**
     * 消费者通道
     *
     * @return
     */
    @Input(STREAM_INPUT)
    SubscribableChannel input();

}
