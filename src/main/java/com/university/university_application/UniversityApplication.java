package com.university.university_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(UniversityApplication.class);
		//to disable web-server
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}
}
