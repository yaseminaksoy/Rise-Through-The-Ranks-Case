package com.caseKartaca.caseKartaca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CaseKartacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseKartacaApplication.class, args);
	}

}
