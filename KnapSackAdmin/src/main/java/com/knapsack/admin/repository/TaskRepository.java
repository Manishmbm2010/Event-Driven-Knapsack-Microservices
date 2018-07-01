package com.knapsack.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.knapsack.admin.model.TaskList;

public interface TaskRepository extends CrudRepository<TaskList, Long> {

}
