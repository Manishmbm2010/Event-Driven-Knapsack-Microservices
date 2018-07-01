package com.knapsack.input.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solution {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long task;
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> items;
	private long time;
	
	
	public List<Integer> getItems() {
		return items;
	}
	public void setItems(List<Integer> items) {
		this.items = items;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
}
