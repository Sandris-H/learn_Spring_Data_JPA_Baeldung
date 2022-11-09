package com.ahanchar;

import static com.ahanchar.persistence.model.predicates.TaskPredicates.tasksByProjectCode;
import static com.ahanchar.persistence.model.predicates.TaskPredicates.tasksSortedByDueDateDesc;
import static com.ahanchar.persistence.model.predicates.TaskPredicates.tasksWithNameContaining;
import static com.ahanchar.persistence.model.predicates.TaskPredicates.tasksWithStatusEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ahanchar.persistence.model.Task;
import com.ahanchar.persistence.model.TaskStatus;
import com.ahanchar.persistence.repository.TaskRepository;
import com.querydsl.core.types.Predicate;

@SpringBootApplication
public class QuerydslApp implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(QuerydslApp.class);

    @Autowired
    private TaskRepository taskRepository;

    public static void main(final String... args) {
        SpringApplication.run(QuerydslApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Predicate tasksIPContainingName = tasksWithNameContaining("Task").and(tasksWithStatusEquals(TaskStatus.IN_PROGRESS));

        Iterable<Task> tasksIPMatchingName = taskRepository.findAll(tasksIPContainingName);

        LOG.info("All In Progress Tasks Containing Name (Predicates) :");
        tasksIPMatchingName.forEach(t -> LOG.info(t.toString()));

        Iterable<Task> tasksDueDateDesc = taskRepository.findAll(tasksSortedByDueDateDesc());

        LOG.info("All Tasks Sorted By Due Date Desc :");
        tasksDueDateDesc.forEach(t -> LOG.info(t.toString()));

        Iterable<Task> tasksWithProjectCode = taskRepository.findAll(tasksByProjectCode("P2"));

        LOG.info("All Tasks with Project Code :");
        tasksWithProjectCode.forEach(t -> LOG.info(t.toString()));

    }

}
