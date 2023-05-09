package com.example.tparkbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TParkBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TParkBeApplication.class, args);
	}

}
