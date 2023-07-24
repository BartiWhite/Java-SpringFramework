package com.example.JavaSpringFramework.controller;

import com.example.JavaSpringFramework.model.TaskRepository;
import com.example.JavaSpringFramework.model.Task;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final TaskRepository repository;

    public TestController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"}) // ignores mapping when params used
    ResponseEntity<List<Task>> readAllTasks(){
        logger.warn("Issue here");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable pageable){ // Spring injects classes which it knows automatically
        logger.info("here");
        return ResponseEntity.ok(repository.findAll(pageable).getContent());
    }

    @GetMapping(value = "/tasks/{id}")
    ResponseEntity<Task> readTask(Pageable pageable, @PathVariable int id){
        logger.info("here");
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task updatedTask){
        if(!repository.existsById(id))
            return ResponseEntity.notFound().build();
        updatedTask.setId((long) id); // just to make sure it will be set correctly, it has some inaccuracies
        repository.save(updatedTask);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tasks")
    ResponseEntity<?> addTask(@RequestBody @Valid Task addedTask){
        Task task = repository.save(addedTask);
        return ResponseEntity.created(URI.create("/" + task.getId())).body(task);
    }
}
