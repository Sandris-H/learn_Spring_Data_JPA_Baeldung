package com.ahanchar.service;

import java.io.IOError;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahanchar.persistence.model.Project;
import com.ahanchar.persistence.model.Task;
import com.ahanchar.persistence.model.TaskStatus;
import com.ahanchar.persistence.repository.ProjectRepository;
import com.ahanchar.persistence.repository.TaskRepository;

@Service
public class ProjectService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional(noRollbackFor = IOError.class)
    public void endProject(Project project) {
        // check if there are tasks in progress
        Set<Task> unfinishedTasks = project.getTasks()
            .stream()
            .filter(t -> !t.getStatus()
                .equals(TaskStatus.DONE))
            .collect(Collectors.toSet());

        if (!unfinishedTasks.isEmpty()) {
            // create continuation Project
            Project continuationProject = new Project(project.getCode()
                .concat("-CONT"),
                project.getName()
                    .concat(" - Cont"),
                project.getDescription());
            projectRepository.save(continuationProject);

            // update Task references
            unfinishedTasks.forEach(t -> t.setProject(continuationProject));
            taskRepository.saveAll(unfinishedTasks);

            writeToExternalLog();
        }
    }

    private void writeToExternalLog() {
        throw new IOError(null);
    }

}
