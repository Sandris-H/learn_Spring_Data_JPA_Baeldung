package com.ahanchar.persistence.repository;

import com.ahanchar.persistence.model.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

}
