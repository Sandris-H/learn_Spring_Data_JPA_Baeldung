package com.ahanchar.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ahanchar.persistence.model.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}
