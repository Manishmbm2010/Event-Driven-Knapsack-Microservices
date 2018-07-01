package com.knapsack.solution.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.knapsack.solution.model.KnapsackModel;
import com.knapsack.solution.model.Solution;

@Service
public class SolutionService {

	/*public void setSolution(Solution solutionObject, List<Integer> solution, Task taskObject) {
		solutionObject.setItem(solution);
		
		solutionList.put(taskObject.getTask(), solutionObject);
	}*/

	@Autowired
	Sender sender;
	
	public void startSolution(KnapsackModel knapsackProblem) throws JsonProcessingException {
		knapsackProblem.getTimestamps().setStarted(System.currentTimeMillis() / 1000L);
		knapsackProblem.setStatus("started");
		sender.send("spring-kafka-solution-update",knapsackProblem);
		Solution sol = new Solution();
		sol.setItems(knapSackAlgo(knapsackProblem.getProblem().getCapacity(), knapsackProblem.getProblem().getWeights(),
				knapsackProblem.getProblem().getValues(), knapsackProblem.getProblem().getValues().length));
		knapsackProblem.getTimestamps().setCompleted(System.currentTimeMillis() / 1000L);
		knapsackProblem.setStatus("completed");
		long timeTaken = knapsackProblem.getTimestamps().getCompleted() - knapsackProblem.getTimestamps().getSumbitted();
		sol.setTime(timeTaken);
		knapsackProblem.setSolution(sol);
		sender.send("spring-kafka-solution-update",knapsackProblem);
		
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	List<Integer> knapSackAlgo(int W, int wt[], int val[], int n) {

		int i, w;
		int K[][] = new int[n + 1][W + 1];
		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		List<Integer> items = new ArrayList<>();
		i = n;
		w = W;
		while (i > 0 && w > 0) {
			if (K[i][w] != K[i - 1][w]) {
				items.add(i - 1);
				w = w - wt[i - 1];
				i = i - 1;
			} else {
				i = i - 1;
			}
		}

		Collections.sort(items);
		return items;

	}

}
