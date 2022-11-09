package com.ahanchar.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ahanchar.persistence.model.Task;
import com.ahanchar.persistence.model.TaskStatus;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
    
    Slice<Task> findByNameLike(String name, Pageable pageable);

    @Query("select t from Task t where t.name like ?1")
    Page<Task> allTasksByName(String name, Pageable pageable);

}
