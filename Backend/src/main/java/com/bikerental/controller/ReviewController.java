package com.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bikerental.dto.request.ReviewRequest;
import com.bikerental.entity.Review;
import com.bikerental.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(
            @RequestBody ReviewRequest request) {

        return ResponseEntity.ok(
                reviewService.createReview(request));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {

        return ResponseEntity.ok(
                reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                reviewService.getReviewById(id));
    }

    @GetMapping("/bike/{bikeId}")
    public ResponseEntity<List<Review>> getReviewsByBikeId(
            @PathVariable Long bikeId) {

        return ResponseEntity.ok(
                reviewService.getReviewsByBikeId(bikeId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewRequest request) {

        return ResponseEntity.ok(
                reviewService.updateReview(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(
            @PathVariable Long id) {

        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully");
    }
}