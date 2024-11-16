package com.growthx.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class BackendDeveloperInternAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDeveloperInternAssignmentApplication.class, args);
	}

}
