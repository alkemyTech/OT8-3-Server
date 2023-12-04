package com.alkemy.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class WalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
		System.out.println("\u001B[32mSwagger-UI: http://localhost:8080/swagger-ui/index.html\u001B[0m");
	}
}
