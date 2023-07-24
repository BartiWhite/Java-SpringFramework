package com.example.JavaSpringFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class JavaSpringFrameworkApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringFrameworkApplication.class, args);
	}

	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		validatingListener.addValidator("beforeCreate", validator());
		validatingListener.addValidator("beforeSave", validator());
	}

	@Bean // applies external class (not defined in Spring) to Spring
		  // has to be defined inside class with @Configuration annotation e.g. @SpringBootApplication
	protected Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
