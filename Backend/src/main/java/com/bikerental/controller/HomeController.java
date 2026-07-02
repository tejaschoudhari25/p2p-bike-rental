package com.bikerental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Project 2 Peer-to-Peer Bike Rental System! 🚴‍♂️";
    }
}