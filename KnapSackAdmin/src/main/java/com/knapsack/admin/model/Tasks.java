package com.knapsack.admin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tasks {
	private static final Logger logger = LoggerFactory.getLogger(Tasks.class);

	private static Tasks tasks;

	private List<Long> submitted = new ArrayList<>();
	private List<Long> started = new ArrayList<>();
	private List<Long> completed = new ArrayList<>();

	// Making tasks as a singleton class
	public Tasks() {

	}

	// Create the task instance if it is not created already
	/*
	 * public static Tasks getInstance() { if (tasks == null) { tasks = new Tasks();
	 * } return tasks; }
	 */
	// Return the list of task in "Submitted" state
	public List<Long> getSubmitted() {
		return submitted;
	}

	// Add the task provided as an argument to "Submitted Task" List
	public void addInSubmitted(Long taskId) {
		submitted.add(taskId);
		logger.info("For Task id " + taskId + " task has been added in list of submitted task");
	}

	// Delete the task provided as an argument from "Submitted Task" List
	public void deleteFromSubmitted(Long taskId) {
		submitted.remove(taskId);
		logger.info("For Task id " + taskId + " task has been deleted from list of submitted task");
	}

	// Return the list of task in "Started" state
	public List<Long> getStarted() {
		return started;
	}

	// Add the task provided as an argument to "Started Task" List
	public void addInStarted(Long taskId) {
		started.add(taskId);
		logger.info("For Task id " + taskId + " task has been added in list of started task");
	}

	// Delete the task provided as an argument from "Started Task" List
	public void deleteFromStarted(Long taskId) {
		started.remove(taskId);
		logger.info("For Task id " + taskId + " task has been deleted from list of started task");
	}

	// Return the list of task in "Completed" state
	public List<Long> getCompleted() {
		return completed;
	}

	// Add the task provided as an argument to "Completed Task" List
	public void addInCompleted(Long taskId) {
		completed.add(taskId);
		logger.info("For Task id " + taskId + " task has been added in list of completed task");
	}

	// Delete the task provided as an argument from "Completed Task" List
	public void deleteFromCompleted(Long taskId) {
		completed.remove(taskId);
		logger.info("For Task id " + taskId + " task has been deleted from list of completed task");
	}

}
