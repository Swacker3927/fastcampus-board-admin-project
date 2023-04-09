package com.fastcampus.boardadminproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusBoardAdminProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastcampusBoardAdminProjectApplication.class, args);
	}

}
