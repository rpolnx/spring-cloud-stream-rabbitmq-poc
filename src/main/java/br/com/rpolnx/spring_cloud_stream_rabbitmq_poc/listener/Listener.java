package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.listener;

import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.broker.Processor;
import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.broker.Sink;
import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.event.CommonEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.util.concurrent.atomic.AtomicInteger;

@EnableBinding({Sink.class})
@Slf4j
public class Listener {

    @SneakyThrows
    @StreamListener(target = Processor.INPUT1)
    public void processMessage1(Message<CommonEvent> message) {
        CommonEvent event = message.getPayload();
        Thread.sleep(1000);
        log.info("Event 1: {}", event);
    }

    @SneakyThrows
    @StreamListener(target = Processor.INPUT2)
    public void processMessage2(Message<CommonEvent> message) {
        CommonEvent event = message.getPayload();
        log.info("Event 2: {}", event);
        throw new RuntimeException("Force dead letter");
    }
}
