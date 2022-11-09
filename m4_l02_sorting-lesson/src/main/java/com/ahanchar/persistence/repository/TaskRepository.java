package com.ahanchar.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ahanchar.persistence.model.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findAllByOrderByDueDateDesc();
    
    List<Task> findAllByOrderByDueDateDescAssigneeLastNameAsc();
    
    List<Task> findByNameContaining(String taskName, Sort sort);
    
}
