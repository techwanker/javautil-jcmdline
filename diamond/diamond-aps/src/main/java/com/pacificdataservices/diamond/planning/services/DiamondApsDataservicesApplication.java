package com.pacificdataservices.diamond.planning.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.pacificdataservices.diamond.models")
public class DiamondApsDataservicesApplication {


	public static void main(String[] args) {
		SpringApplication.run(DiamondApsDataservicesApplication.class, args);
	}
}
