package com.write;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WriteApplication.class, args);
	}
}
