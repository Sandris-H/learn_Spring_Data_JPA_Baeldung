package com.ahanchar.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ahanchar.persistence.model.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    Page<Task> findByProjectId(long id, Pageable pageable);
}
