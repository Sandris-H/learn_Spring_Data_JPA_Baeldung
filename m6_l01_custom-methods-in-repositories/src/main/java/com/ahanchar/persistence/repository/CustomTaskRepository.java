package com.ahanchar.persistence.repository;

import java.util.List;

import com.ahanchar.persistence.model.Task;

public interface CustomTaskRepository {
    List<Task> search(String searchParam);

    List<Task> findAll();
}
