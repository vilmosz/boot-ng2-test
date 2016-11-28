package com.ixxus.poc.peerreview.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceClassDelegateSample implements JavaDelegate {

	@Override
	public void execute(DelegateExecution delegateExecution) {
		System.out.println("Executed process with key " + delegateExecution.getProcessBusinessKey()
				+ " with process definition Id " + delegateExecution.getProcessDefinitionId()
				+ " with process instance Id " + delegateExecution.getProcessInstanceId() + " and current task name is "
				+ delegateExecution.getCurrentActivityId());

	}

}