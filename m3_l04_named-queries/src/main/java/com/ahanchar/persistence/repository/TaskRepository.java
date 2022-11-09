package com.ahanchar.persistence.repository;

import com.ahanchar.persistence.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
