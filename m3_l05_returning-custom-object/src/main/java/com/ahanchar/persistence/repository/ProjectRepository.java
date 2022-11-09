package com.ahanchar.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Project;
import com.ahanchar.persistence.projection.ProjectClosed;
import com.ahanchar.persistence.projection.ProjectNative;
import com.ahanchar.persistence.projection.ProjectClass;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Iterable<Project> findByNameContaining(String name);

    List<ProjectClosed> findClosedByNameContaining(String name);

    List<ProjectClass> findClassByNameContaining(String name);

    @Query(nativeQuery = true, value = "SELECT p.id, p.name, count(t.id) AS taskCount" // @formatter:off
        + " FROM project p"
        + " LEFT JOIN task t ON p.id=t.project_id "
        + " GROUP BY p.id") // @formatter:on
    List<ProjectNative> getProjectStatistics();

}
