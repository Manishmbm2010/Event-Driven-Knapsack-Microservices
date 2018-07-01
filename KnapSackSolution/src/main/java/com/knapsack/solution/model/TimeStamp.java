package com.knapsack.solution.model;

public class TimeStamp {
	private Long sumbitted;
	private Long started;
	private Long completed;

	public TimeStamp() {
		this.sumbitted = System.currentTimeMillis() / 1000L;
		this.started = null;
		this.completed = null;
	}
	
	public TimeStamp(Long sumbitted, Long started, Long completed) {
		this.sumbitted = System.currentTimeMillis() / 1000L;
		this.started = started;
		this.completed = completed;
	}

	public Long getSumbitted() {
		return sumbitted;
	}

	public void setSumbitted(Long sumbitted) {
		this.sumbitted = sumbitted;
	}

	public Long getStarted() {
		return started;
	}

	public void setStarted(Long started) {
		this.started = started;
	}

	public Long getCompleted() {
		return completed;
	}

	public void setCompleted(Long completed) {
		this.completed = completed;
	}
}
