package com.example.petshop_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class PetshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetshopApiApplication.class, args);
	}

}
