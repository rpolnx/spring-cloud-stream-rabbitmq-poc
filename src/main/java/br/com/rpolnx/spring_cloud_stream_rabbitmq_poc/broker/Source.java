package br.com.rpolnx.spring_cloud_stream_rabbitmq_poc.broker;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {

  String OUTPUT1 = "custom-channel-1";
  String OUTPUT2 = "custom-channel-2";

  @Output(Source.OUTPUT1)
  MessageChannel output1();

  @Output(Source.OUTPUT2)
  MessageChannel output2();

}