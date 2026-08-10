package com.bikerental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    Optional<Bike> findByEmail(String email);
}
