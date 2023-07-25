package com.example.JavaSpringFramework.controller;

import com.example.JavaSpringFramework.TaskConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    private final DataSourceProperties dataSource;
    private final TaskConfigurationProperties prop;

    public InfoController(DataSourceProperties dataSource, TaskConfigurationProperties prop) {
        this.dataSource = dataSource;
        this.prop = prop;
    }

    @GetMapping("/info/url")
    String url() {
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    boolean myProp() {
        return prop.isAllowMultipleTasksFromTemplate();
    }
}
