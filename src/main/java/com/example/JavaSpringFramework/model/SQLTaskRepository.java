package com.example.JavaSpringFramework.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource // (path = "todos", collectionResourceRel = "todos") changes path and entity description
@Repository // Spring finds private packages
interface SQLTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
}
