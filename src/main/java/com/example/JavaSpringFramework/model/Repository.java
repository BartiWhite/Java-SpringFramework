package com.example.JavaSpringFramework.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface Repository extends JpaRepository<Task, Integer> {
    @Override
    @RestResource(exported = false) // prevents from deleting the task
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Task entity);
}
