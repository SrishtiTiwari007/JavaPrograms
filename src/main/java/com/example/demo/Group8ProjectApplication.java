package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class Group8ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group8ProjectApplication.class, args);
		System.out.println("hello");
	}

}
