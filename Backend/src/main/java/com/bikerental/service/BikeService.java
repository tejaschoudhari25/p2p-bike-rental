package com.bikerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.dto.request.BikeRequest;
import com.bikerental.entity.Bike;
import com.bikerental.repository.BikeRepository;

@Service
public class BikeService {
    
    @Autowired
    private BikeRepository bikeRepository;

    public void addBike(BikeRequest request){
        Bike bike = new Bike(
            request.getName(),
            request.getBrand(),
            request.getModel(),
            request.getPricePerDay(),
            request.getCity(),
            request.getAvailable()
        );
        bikeRepository.save(bike);
    }
}
