package com.ixxus.poc.peerreview.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ixxus.poc.peerreview.domain.Person;
import com.ixxus.poc.peerreview.repository.PersonRepository;

@Service
@Transactional
public class ReviewService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private PersonRepository personRepository;

	public void startProcess(String assignee) {

		Person person = personRepository.findByUsername(assignee);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("reviewer", person);
		runtimeService.startProcessInstanceByKey("journalReviewProcess", variables);
	}

	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

	public List<Task> getAllTasks() {
		return taskService.createTaskQuery().list();
	}

}
