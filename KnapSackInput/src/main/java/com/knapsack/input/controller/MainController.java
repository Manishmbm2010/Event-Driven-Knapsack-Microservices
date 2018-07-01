package com.knapsack.input.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.knapsack.input.model.KnapsackModel;
import com.knapsack.input.service.MainService;
import com.knapsack.input.service.Sender;
import com.knapsack.output.views.Views.*;

@RestController
public class MainController {

	@Autowired
	private Sender sender;

	@Autowired
	MainService mainService;

	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String greeting() {
		return "Hello Spring ";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/knapsack/tasks", produces = "application/json")
	public String registerProblem(@RequestBody KnapsackModel inputProblem) throws JsonProcessingException {
		System.out.println("Probelm task id is " + inputProblem.getTask());
		mainService.checkProblem(inputProblem);
		mainService.saveKnapsackProblem(inputProblem);
		sender.send("spring-kafka", inputProblem);
		return mapper.writerWithView(TaskResponse.class)
				.writeValueAsString(mainService.getKnapsackProblem(inputProblem.getTask()));

	}

	@RequestMapping(method = RequestMethod.GET, value = "/knapsack/solution/{id}", produces = "application/json")
	public ResponseEntity getSolution(@PathVariable Long id) throws JsonProcessingException {
		KnapsackModel knapsackModel = mainService.getKnapsackProblem(id);
		String knapsack = mapper.writerWithView(FullResponse.class).writeValueAsString(knapsackModel);
		if (knapsackModel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Message\""+" : "+"\"Task Id dosen't exist , May be wrong task submitted in request\"}");
		} else {
			if (knapsackModel.getSolution() == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Message\""+" : "+"\"Solution doesn't not yet exists or processed for this task , Please try after sometime\"}");
			} else
				return new ResponseEntity<String>(knapsack, HttpStatus.OK);
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/knapsack/tasks/{id}", produces = "application/json")
	public ResponseEntity getTaskStatus(@PathVariable Long id) throws JsonProcessingException {
		KnapsackModel knapsackModel = mainService.getKnapsackProblem(id);
		String knapsack = mapper.writerWithView(TaskResponse.class)
				.writeValueAsString(mainService.getKnapsackProblem(id));
		if (knapsackModel ==null) {
			//return new ResponseEntity<String>("Task Id donot exist , May be wrong task submitted in request",HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Message\""+" : "+"\"Task Id dosen't exist , May be wrong task submitted in request\"}");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(knapsack);
		}

	}

}
