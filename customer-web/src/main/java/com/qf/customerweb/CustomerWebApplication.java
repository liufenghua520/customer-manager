package com.qf.customerweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
public class CustomerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerWebApplication.class, args);
    }

}
