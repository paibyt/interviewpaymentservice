package com.interview.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InterviewPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPaymentServiceApplication.class, args);
	}
}
