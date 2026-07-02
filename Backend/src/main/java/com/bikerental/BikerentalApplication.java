package com.bikerental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.bikerental.controller",
        "com.bikerental.service",
        "com.bikerental.repository",
        "com.bikerental.entity",
        "com.bikerental.config",
        "com.bikerental.security",
        "com.bikerental.dto",
        "com.bikerental.exception"
})
public class BikerentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikerentalApplication.class, args);
    }
}