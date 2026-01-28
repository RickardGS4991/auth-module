package com.example.tandapp;

import org.springframework.boot.SpringApplication;

public class TestTandappApplication {

	public static void main(String[] args) {
		SpringApplication.from(TandappApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
