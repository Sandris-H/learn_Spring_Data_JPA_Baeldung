package com.ahanchar.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ahanchar.persistence.model.Project;

@SpringBootTest
@Transactional
class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void givenNewProject_whenSaved_thenSuccess() {
        Project newProject = new Project("PTEST-1", "Test Project 1", "Description for project PTEST-1");
        assertNotNull(projectRepository.save(newProject));
    }

    @Test
    void givenProjectCreated_whenFindById_thenSuccess() {
        Project newProject = new Project("PTEST-1", "Test Project 1", "Description for project PTEST-1");
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());
        assertEquals(retrievedProject.get(), newProject);
    }
}