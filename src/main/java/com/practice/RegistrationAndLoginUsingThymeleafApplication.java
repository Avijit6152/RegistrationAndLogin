package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.practice.securityConfig.SecurityConfiguration;

@SpringBootApplication
public class RegistrationAndLoginUsingThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationAndLoginUsingThymeleafApplication.class, args);
	}

}
