package com.example.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootProj11Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProj11Application.class, args);
	}
	
	@GetMapping(path="/msg")
	public String getMessage() {
		return "Working with Docker";
	}
}
