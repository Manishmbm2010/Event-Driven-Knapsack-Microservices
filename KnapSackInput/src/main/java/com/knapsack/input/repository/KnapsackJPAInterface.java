package com.knapsack.input.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.knapsack.input.model.KnapsackModel;

@Component
public interface KnapsackJPAInterface extends CrudRepository<KnapsackModel, String> {

	KnapsackModel findByTask(Long long1);

/*	public Customer findById(int id);

	public Customer findByfirstName(String name);*/
}
