package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.scheduler;

import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.event.CommonEvent;
import br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TimerScheduler {

    private final Producer producer;

    @Scheduled(fixedDelayString = "1000")
    public void schedule() {
        log.info("Executing...");
        producer.publishMessage1(CommonEvent.generate());
        producer.publishMessage2(CommonEvent.generate());
        log.info("Ending execution...");
    }
}
