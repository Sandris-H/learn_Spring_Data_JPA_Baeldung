package com.ahanchar.domain.task.model;

import com.ahanchar.persistence.model.Task;

public class TaskUpdated {

    private Long taskId;

    public TaskUpdated(Task task) {
        this.taskId = task.getId();
    }

    public Long getTaskId() {
        return taskId;
    }

}