package com.ahanchar.persistence.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}
