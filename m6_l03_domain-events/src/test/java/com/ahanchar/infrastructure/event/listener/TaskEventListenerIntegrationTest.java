package com.ahanchar.infrastructure.event.listener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ahanchar.domain.task.model.TaskUpdated;
import com.ahanchar.infrastructure.project.listener.ProjectEventListeners;
import com.ahanchar.persistence.model.Project;
import com.ahanchar.persistence.model.Task;
import com.ahanchar.persistence.repository.ProjectRepository;
import com.ahanchar.persistence.repository.TaskRepository;

@SpringBootTest
class TaskEventListenerIntegrationTest {

    @MockBean
    private ProjectEventListeners taskEventListener;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void whenAddTasktoProject_thenDomainEventTriggered() {
        Project project = projectRepository.findById(1L)
            .get();

        taskRepository.save(new Task("Sample Name", "Sample Description", LocalDate.now(), project));

        // one time for the startup process, and the second for this test method
        verify(taskEventListener, times(2)).taskUpdatedListener(any(TaskUpdated.class));
    }

}
