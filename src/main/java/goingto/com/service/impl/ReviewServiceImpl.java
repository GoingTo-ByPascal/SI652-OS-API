package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.interaction.Review;
import goingto.com.repository.interaction.ReviewRepository;
import goingto.com.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }


    @Override
    public List<Review> getAllReviewsByUserProfileId(Integer userProfileId) {
        return reviewRepository.getByUserProfileId(userProfileId);
    }

    @Override
    public List<Review> getAllReviewsByLocatableId(Integer locatableId) {
        return reviewRepository.getByLocatableId(locatableId);
    }

    @Override
    public List<Review> getByUserProfileIdAndLocatableId(Integer userProfileId, Integer locatableId) {
        return reviewRepository.findByUserProfileIdAndLocatableId(userProfileId,locatableId);
    }

    @Override
    public Review getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }

    @Override
    public Review createReview(Review review) {
        review.setReviewedAt(Instant.now());
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Integer reviewId, Review reviewDetails) {
        return reviewRepository.findById(reviewId).map(review -> {
            review.setComment(reviewDetails.getComment());
            review.setStars(reviewDetails.getStars());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }

    @Override
    public ResponseEntity<?> deleteReview(Integer reviewId) {
        return reviewRepository.findById(reviewId).map(review -> {
            reviewRepository.delete(review);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }
}
