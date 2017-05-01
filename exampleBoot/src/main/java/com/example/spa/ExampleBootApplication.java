package com.example.spa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.spa.dao")
@SpringBootApplication
public class ExampleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleBootApplication.class, args);
	}
}
