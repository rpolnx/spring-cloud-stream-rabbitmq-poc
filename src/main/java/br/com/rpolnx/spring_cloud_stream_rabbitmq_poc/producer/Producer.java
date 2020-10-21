package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.producer;

import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.broker.Processor;
import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.broker.Source;
import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.event.CommonEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Source.class})
@RequiredArgsConstructor
public class Producer {
    private final Source source;

    public void publishMessage1(CommonEvent event) {
        source.output1().send(MessageBuilder.withPayload(event)
                .setHeader("x-publish", "messsage-1")
                .build());
    }

    @SendTo(Processor.OUTPUT2)
    public void publishMessage2(CommonEvent event) {
        source.output2().send(MessageBuilder.withPayload(event)
                .setHeader("x-publish", "messsage-1")
                .build());
    }
}
