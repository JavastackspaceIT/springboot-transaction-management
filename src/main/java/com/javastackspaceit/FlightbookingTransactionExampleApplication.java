package com.javastackspaceit;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FlightbookingTransactionExampleApplication {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FlightbookingTransactionExampleApplication.class);
// added comment for bootstraping main method for this applicaiton 
	public static void main(String[] args) {
		logger.info("enter into main method");
		SpringApplication.run(FlightbookingTransactionExampleApplication.class, args);
	}

}
