package com.nicolasgfe.task.form;

import com.nicolasgfe.task.enumeration.TaskStatus;
import com.nicolasgfe.task.model.Task;
import com.nicolasgfe.task.repository.TaskRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateStatusTaskForm {

	@NotNull
	@NotEmpty
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Task converter(Long id, TaskRepository taskRepository) {
		Task task = taskRepository.findById(id).get();
		task.setStatus(TaskStatus.valueOf(status));
		return task;
	}

	public Task converter() {
		return new Task(status);
	}

}
