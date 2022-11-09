package com.ahanchar.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Worker;
import com.ahanchar.persistence.projection.WorkerOpen;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

    List<WorkerOpen> findByFirstName(String firstName);

}
