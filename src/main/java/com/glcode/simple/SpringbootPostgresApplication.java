package com.glcode.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.glcode.simple.model.entity"})
@EnableJpaRepositories(basePackages = {"com.glcode.simple.repository"})
public class SpringbootPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostgresApplication.class, args);
	}

}
