package com.kuds.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoappApplication {

	// SpringApplication.runでコンテナを作成している
	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);
	}

}
