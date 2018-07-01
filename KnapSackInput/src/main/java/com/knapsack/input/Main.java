package com.knapsack.input;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = { "com.knapsack.input.controller", "com.knapsack.input.service",
		"com.knapsack.input.config","com.knapsack.input.model","com.knapsack.input.repository","com.knapsack.input.views" })


@SpringBootApplication
public class Main {

	// static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		// logger.info("Probelm Micorservice has started at");
	}

}
