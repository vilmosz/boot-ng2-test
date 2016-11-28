package com.ixxus.poc.peerreview;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TaskExampleTest {

	private String filename = "processes/HumanAndServiceTaskExample.bpmn20.xml";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	private RepositoryService repositoryService;
	private RuntimeService runtimeService;
	private TaskService taskService;

	@Before
	public void setUp() {
		runtimeService = activitiRule.getRuntimeService();
		repositoryService = activitiRule.getRepositoryService();
		taskService = activitiRule.getTaskService();
	}

	@Test
	public void startProcess() throws Exception {

		/*
		 * Deploy the process
		 */
		repositoryService.createDeployment().enableDuplicateFiltering()
				.addInputStream("HumanAndServiceTaskExample.bpmn20.xml",
						getClass().getClassLoader().getResourceAsStream(filename))
				.deploy();

		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("processStartedBy", "Dhananjay");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("HumanAndServiceTaskExample",
				variableMap);

		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " " + processInstance.getProcessDefinitionId());
	}

	@Test
	public void claimAndCompleteHumanTask() throws Exception {
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("HumanAndServiceTaskExample")
				.taskDefinitionKey("HumanTaskExample").list();
		for (Task task : tasks) {
			taskService.claim(task.getId(), "DJ");
			Map<String, Object> variableMap = new HashMap<String, Object>();
			variableMap.put("HumanTaskCompletedBy", "DJ");
			taskService.complete(task.getId(), variableMap);
		}
	}
}
