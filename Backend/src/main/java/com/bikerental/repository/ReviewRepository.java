package com.bikerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBikeId(Long bikeId);
}