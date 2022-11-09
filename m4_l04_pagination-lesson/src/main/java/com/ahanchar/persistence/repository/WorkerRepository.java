package com.ahanchar.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.ahanchar.persistence.model.Worker;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

}
