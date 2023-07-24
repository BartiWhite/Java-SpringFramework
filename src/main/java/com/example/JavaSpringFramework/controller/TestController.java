package com.example.JavaSpringFramework.controller;

import com.example.JavaSpringFramework.model.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final Repository repository;

    public TestController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    ResponseEntity<?> readAllTasks(){
        logger.warn("Issue here");
        return ResponseEntity.ok(repository.findAll());
    }
}
