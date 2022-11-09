package com.ahanchar.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Iterable<Project> findByName(String name);

    Iterable<Project> findByNameIsNot(String name);

    Iterable<Project> findByNameStartingWith(String name);

    Iterable<Project> findByNameEndingWith(String name);

    Iterable<Project> findByNameContaining(String name);

    Iterable<Project> findByNameLike(String likePattern);

    Iterable<Project> findDistinctByTasksNameContaining(String taskName);
}
