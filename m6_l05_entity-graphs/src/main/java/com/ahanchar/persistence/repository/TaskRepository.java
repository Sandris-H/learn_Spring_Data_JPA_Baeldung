package com.ahanchar.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Task;
import com.ahanchar.persistence.model.TaskStatus;

public interface TaskRepository extends CrudRepository<Task, Long> {
    
    @EntityGraph(attributePaths = {"assignee", "project"})
    List<Task> findByStatus(TaskStatus taskStatus);
}
