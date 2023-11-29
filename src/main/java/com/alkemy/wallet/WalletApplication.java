package com.alkemy.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;
import java.net.URI;
import java.util.logging.Logger;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
        System.out.println("Port: http://localhost:8080");
        System.out.println("Swagger: http://localhost:8080/swagger-ui/index.html");
    }
}