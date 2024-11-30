package com.example.food;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
		System.out.println("Food Application");
	}
	@Bean
	ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
