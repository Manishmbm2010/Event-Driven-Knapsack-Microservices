package com.knapsack.input.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knapsack.input.model.KnapsackModel;
import com.knapsack.input.model.Problem;
import com.knapsack.input.repository.KnapsackJPAInterface;

@Service
public class MainService {

	Map<Long, KnapsackModel> knapsackList = new HashMap<>();

	@Autowired
	KnapsackJPAInterface knapsackJPAInterface;

	public String checkProblem(KnapsackModel knapsackProblem) {
		if (knapsackProblem.getProblem().getCapacity() < 0) {
			return "NOK";
		}
		for (int weight : knapsackProblem.getProblem().getWeights()) {
			if (weight < 0) {
				return "NOK";
			}
		}
		for (int value : knapsackProblem.getProblem().getValues()) {
			if (value < 0) {
				return "NOK";
			}
		}

		knapsackList.put(knapsackProblem.getTask(), knapsackProblem);
		return "OK";
	}

	public KnapsackModel getKnapsackProblem(Long long1) {
		return knapsackJPAInterface.findByTask(long1);
	}

	public void saveKnapsackProblem(KnapsackModel problem) {
		knapsackJPAInterface.save(problem);
	}

	public void updateKnapsackProblem(KnapsackModel problem) {
		knapsackJPAInterface.save(problem);
	}
}
