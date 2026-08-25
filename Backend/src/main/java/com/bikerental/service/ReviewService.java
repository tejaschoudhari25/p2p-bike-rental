package com.bikerental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.dto.request.ReviewRequest;
import com.bikerental.entity.Review;
import com.bikerental.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(ReviewRequest request) {

        Review review = new Review(
                request.getUserId(),
                request.getBikeId(),
                request.getRating(),
                request.getComment()
        );

        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getReviewsByBikeId(Long bikeId) {
        return reviewRepository.findByBikeId(bikeId);
    }

    public Review updateReview(Long id, ReviewRequest request) {

        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setUserId(request.getUserId());
        review.setBikeId(request.getBikeId());
        review.setRating(request.getRating());
        review.setComment(request.getComment());

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}