package com.pacificdataservices.diamond.apswebservices;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.pacificdataservices.diamond.planning.services",
  })
public class Application {
	
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);
    }

}
