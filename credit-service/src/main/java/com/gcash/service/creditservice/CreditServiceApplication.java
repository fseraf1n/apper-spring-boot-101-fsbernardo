package com.gcash.service.creditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner helloWorld() {
		return args -> System.out.println("Hello, world!");
	}
}
