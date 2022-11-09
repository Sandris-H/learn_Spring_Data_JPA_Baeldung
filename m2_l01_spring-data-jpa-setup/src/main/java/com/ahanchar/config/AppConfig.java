package com.ahanchar.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ahanchar.persistence")
@EntityScan("com.ahanchar.persistence.model")
public class AppConfig {

}
