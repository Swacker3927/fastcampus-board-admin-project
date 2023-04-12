package com.fastcampus.boardadminproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastCampusBoardAdminProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FastCampusBoardAdminProjectApplication.class, args);
	}
}
