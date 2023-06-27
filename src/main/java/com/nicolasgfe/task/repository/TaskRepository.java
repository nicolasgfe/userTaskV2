package com.nicolasgfe.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolasgfe.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
