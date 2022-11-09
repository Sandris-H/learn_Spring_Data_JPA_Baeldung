package com.ahanchar.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Iterable<Project> findByNameContaining(String name);
}
