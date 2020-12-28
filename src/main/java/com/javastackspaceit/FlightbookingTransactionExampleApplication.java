package com.javastackspaceit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FlightbookingTransactionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightbookingTransactionExampleApplication.class, args);
	}

}
