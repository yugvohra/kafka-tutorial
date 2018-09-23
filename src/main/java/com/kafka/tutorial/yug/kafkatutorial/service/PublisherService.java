package com.kafka.tutorial.yug.kafkatutorial.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.tutorial.yug.kafkatutorial.model.KafkaFacebookMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by vohray on 6/23/18.
 */
@Service
@Slf4j
public class PublisherService {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  @Autowired
  ObjectMapper mapper;

  @Value("${app.topic.fcb}")
  private String topic;

  public void publish(KafkaFacebookMessage message) {
    log.info("sending message='{}' to topic='{}'", message, topic);
    try {
      kafkaTemplate.send(topic, mapper.writeValueAsString(message));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}

