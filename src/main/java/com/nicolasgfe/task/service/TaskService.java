package com.nicolasgfe.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nicolasgfe.task.dto.TaskDTO;
import com.nicolasgfe.task.form.TaskForm;
import com.nicolasgfe.task.form.UpdateStatusTaskForm;
import com.nicolasgfe.task.form.UpdateTaskForm;
import com.nicolasgfe.task.model.Task;
import com.nicolasgfe.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task createTask(TaskForm task) {
		return taskRepository.save(task.converter());
	}

	public Task updateTask(Long id, UpdateTaskForm task) {
		return taskRepository.save(task.converter(id, taskRepository));
	}
	
	public Task updateTask(Long id, UpdateStatusTaskForm task) {
		return taskRepository.save(task.converter(id, taskRepository));
	}

	public Page<TaskDTO> getAllTasks(Pageable pagination) {
		Page<Task> tasks = taskRepository.findAll(pagination);
		Page<TaskDTO> tasksDTO = TaskDTO.converter(tasks);
		return tasksDTO;
	}
	
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
