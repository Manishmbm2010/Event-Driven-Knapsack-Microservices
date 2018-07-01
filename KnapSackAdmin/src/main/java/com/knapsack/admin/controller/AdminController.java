package com.knapsack.admin.controller;

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.knapsack.admin.model.KnapsackModel;
import com.knapsack.admin.model.Problem;
import com.knapsack.admin.model.Solution;
import com.knapsack.admin.model.Tasks;
import com.knapsack.admin.service.AdminService;
import com.knapsack.admin.service.Receiver;

@RestController
public class AdminController {

	@Autowired
	private Receiver receiver;
	@Autowired
	AdminService adminService;

	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String greeting() {
		return "Hello Spring ";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin/task" ,produces="application/json")
	public Tasks getTasksSummary() {
		return adminService.getTaskList();
	}
}
