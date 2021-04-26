package com.example.vc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class VoteChainApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteChainApplication.class, args);
	}

}
