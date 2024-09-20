package com.ofss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApiJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiJdbcTemplateApplication.class, args);
		System.out.println("customer api with jdbc template started...!!!");
	}

}
