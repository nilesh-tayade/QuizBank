package com.quizz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizzBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzBankApplication.class, args);
		System.out.println("Quizz Bank working");
	}

}
