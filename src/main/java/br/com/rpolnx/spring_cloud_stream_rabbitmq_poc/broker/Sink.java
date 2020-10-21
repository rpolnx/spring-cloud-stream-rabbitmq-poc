package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.broker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    String INPUT1 = "custom-channel-1";
    String INPUT2 = "custom-channel-2";

    @Input(Sink.INPUT1)
    SubscribableChannel input();

    @Input(Sink.INPUT2)
    SubscribableChannel input2();

}