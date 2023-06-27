package com.nicolasgfe.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolasgfe.task.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
