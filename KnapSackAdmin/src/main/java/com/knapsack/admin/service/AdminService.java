package com.knapsack.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.knapsack.admin.model.KnapsackModel;
import com.knapsack.admin.model.TaskList;
import com.knapsack.admin.model.Tasks;
import com.knapsack.admin.repository.TaskRepository;

@Service
public class AdminService {

	@Autowired
	TaskRepository taskRepository;

	public void updateTaskList(KnapsackModel knapsackModel) {
		String status = knapsackModel.getStatus();
		Long taskId = knapsackModel.getTask();
		TaskList taskList = null;
		if (status.equals("submitted")) {
			taskList = new TaskList(taskId, 'Y', 'N', 'N');
			taskRepository.save(taskList);
		} else if (status.equals("started")) {
			taskList = new TaskList(taskId, 'N', 'Y', 'N');
			taskRepository.save(taskList);
		} else if (status.equals("completed")) {
			taskList = new TaskList(taskId, 'N', 'N', 'Y');
			taskRepository.save(taskList);
		}
	}

	public Tasks getTaskList() {
		Iterable<TaskList> taskList = taskRepository.findAll();
		Tasks tasks = new Tasks();
		for (TaskList task : taskList) {
			if (task.getSubmitted() == 'Y') {
				tasks.addInSubmitted(task.getTask());
			} else if (task.getStarted() == 'Y') {
				tasks.addInStarted(task.getTask());
			} else if (task.getCompleted() == 'Y') {
				tasks.addInCompleted(task.getTask());
			}
		}
		return tasks;
	}
}
