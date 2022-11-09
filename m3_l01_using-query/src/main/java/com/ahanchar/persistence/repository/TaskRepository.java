package com.ahanchar.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query("select count(*), year(t.dueDate) from Task t group by year(t.dueDate)")
    List<List<Integer>> countByDueYear();
}
