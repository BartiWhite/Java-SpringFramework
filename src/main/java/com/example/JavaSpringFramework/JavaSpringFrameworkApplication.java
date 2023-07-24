package com.example.JavaSpringFramework;

import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;



@SpringBootApplication
public class JavaSpringFrameworkApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringFrameworkApplication.class, args);
	}

	@Bean // applies external class (not defined in Spring) to Spring
		  // has to be defined inside class with @Configuration annotation e.g. @SpringBootApplication
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
