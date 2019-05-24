package com.mirana.stream.streamtest;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyProcessor {

    String STREAM_OUTPUT = "stream_output";

    /**
     * 生产者通道
     *
     * @return
     */
    @Output(STREAM_OUTPUT)
    MessageChannel output();

}
