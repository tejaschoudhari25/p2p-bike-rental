package com.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bikerental.dto.request.BikeRequest;
import com.bikerental.entity.Bike;
import com.bikerental.service.BikeService;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping
    public ResponseEntity<?> addBike(@RequestBody BikeRequest request) {
        bikeService.addBike(request);
        return ResponseEntity.ok("Bike added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        return ResponseEntity.ok(bikeService.getAllBikes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id) {
        return ResponseEntity.ok(bikeService.getBikeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(
            @PathVariable Long id,
            @RequestBody BikeRequest request) {

        Bike updatedBike = bikeService.updateBike(id, request);
        return ResponseEntity.ok(updatedBike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBike(@PathVariable Long id) {
        bikeService.deleteBike(id);
        return ResponseEntity.ok("Bike deleted successfully");
    }
}