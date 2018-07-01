package com.knapsack.solution.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knapsack.solution.model.KnapsackModel;


@Service
public class Sender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(Sender.class);
  ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topic, KnapsackModel payload) throws JsonProcessingException {
    LOGGER.info("sending payload='{}' to topic='{}'", mapper.writeValueAsString(payload), topic);
        kafkaTemplate.send(topic, mapper.writeValueAsString(payload));
  }
}