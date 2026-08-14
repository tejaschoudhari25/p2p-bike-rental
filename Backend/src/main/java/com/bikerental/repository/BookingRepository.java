package com.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    
}
