package com.ahanchar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahanchar.persistence.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
