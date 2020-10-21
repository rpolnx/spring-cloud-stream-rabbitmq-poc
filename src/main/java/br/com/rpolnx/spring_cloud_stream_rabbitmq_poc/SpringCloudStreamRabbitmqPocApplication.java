package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCloudStreamRabbitmqPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamRabbitmqPocApplication.class, args);
	}

}
