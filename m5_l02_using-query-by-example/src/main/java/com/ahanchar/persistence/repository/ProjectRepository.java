package com.ahanchar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahanchar.persistence.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Iterable<Project> findByNameContaining(String name);
}
