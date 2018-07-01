package com.knapsack.solution.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonView;

public class KnapsackModel {

	private Problem problem;

	private Solution solution;

	private Long task;

	private TimeStamp timestamps;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KnapsackModel() {

		//this.task = UUID.randomUUID().toString();
		this.timestamps = new TimeStamp();
		this.status = "submitted";
		// Event should be trigger in even store so admin service update the task status
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public Long getTask() {
		return task;
	}

	public void setTask(Long task) {
		this.task = task;
	}

	public TimeStamp getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(TimeStamp timestamps) {
		this.timestamps = timestamps;
	}

}
