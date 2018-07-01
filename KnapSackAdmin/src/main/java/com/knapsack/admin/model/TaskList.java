package com.knapsack.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskList {

	@Id
	@Column(name = "Task_ID")
	Long task;
	@Column(name = "Submitted_Flag")
	char submitted;

	@Column(name = "Started_Flag")
	char started;

	@Column(name = "Completed_Flag")
	char completed;

	public TaskList() {
	}

	public TaskList(Long taskId, char submittedFlag, char startedFlag, char completedFlag) {
		this.task = taskId;
		this.submitted = submittedFlag;
		this.started = startedFlag;
		this.completed = completedFlag;
	}

	public Long getTask() {
		return task;
	}

	public void setTask(Long task) {
		this.task = task;
	}

	public char getSubmitted() {
		return submitted;
	}

	public void setSubmitted(char submitted) {
		this.submitted = submitted;
	}

	public char getStarted() {
		return started;
	}

	public void setStarted(char started) {
		this.started = started;
	}

	public char getCompleted() {
		return completed;
	}

	public void setCompleted(char completed) {
		this.completed = completed;
	}

}
