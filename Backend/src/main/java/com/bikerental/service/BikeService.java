package com.bikerental.service;

import java.util.List;

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

    public List<Bike> getAllBikes(){
         return bikeRepository.findAll();
    }

    public Bike getBikeById(Long id){
        return bikeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bike not found"));
    }

    public Bike updateBike(Long id, BikeRequest request){
        Bike bike = bikeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bike not found"));

        bike.setAvailable(request.getAvailable());
        bike.setPricePerDay(request.getPricePerDay());

        return bikeRepository.save(bike);
    }

    public void deleteBike(Long id){
        bikeRepository.deleteById(id);
    }
}
