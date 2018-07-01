package com.knapsack.input.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.knapsack.output.views.Views.*;

@Entity
public class KnapsackModel {

	@OneToOne(cascade=CascadeType.ALL)
	@JsonView(FullResponse.class)
	private Problem problem;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonView(FullResponse.class)
	private Solution solution;

	@Id
	@JsonView(TaskResponse.class)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long task;

	@OneToOne(cascade=CascadeType.ALL)
	@JsonView(TaskResponse.class)
	private TimeStamp timestamps;

	@JsonView(TaskResponse.class)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KnapsackModel() {

		//this.task = UUID.randomUUID().toString();
		//this.task = Long.parseLong("2");
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
