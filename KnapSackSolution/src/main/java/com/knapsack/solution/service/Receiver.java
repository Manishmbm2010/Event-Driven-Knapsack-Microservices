package com.knapsack.solution.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knapsack.solution.model.KnapsackModel;

public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	private static ObjectMapper mapper = new ObjectMapper();
	// @KafkaListener(topics = "${kafka.topic.helloworld}")
	@Autowired
	SolutionService solutionService;

	@KafkaListener(topics = "spring-kafka")
	public void receive(String payload) {
		LOGGER.info("received payload='{}'", payload);
		try {
			solutionService.startSolution(mapper.readValue(payload, KnapsackModel.class));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}