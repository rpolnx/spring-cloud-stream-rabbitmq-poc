package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonEvent {
    private String id;
    private String name;
    private Map<String, String> props;
    private LocalDate localDate;
    private LocalDateTime localDateTime;

    public static CommonEvent generate() {
        return new EasyRandom(new EasyRandomParameters().collectionSizeRange(3, 10).seed(System.currentTimeMillis())).nextObject(CommonEvent.class);
    }
}
