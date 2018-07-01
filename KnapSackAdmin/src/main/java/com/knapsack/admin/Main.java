package com.knapsack.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.knapsack.admin.controller", "com.knapsack.admin.service",
		"com.knapsack.admin.config","com.knapsack.admin.repository" ,"com.knapsack.admin.model"  })

@SpringBootApplication
public class Main {

	// static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		// logger.info("Probelm Micorservice has started at");
	}

}
