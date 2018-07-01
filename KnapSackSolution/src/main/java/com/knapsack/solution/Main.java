package com.knapsack.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.knapsack.solution.controller", "com.knapsack.solution.service",
		"com.knapsack.solution.config","com.knapsack.solution.model"})

@SpringBootApplication
public class Main {

	// static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		// logger.info("Probelm Micorservice has started at");
	}

}
