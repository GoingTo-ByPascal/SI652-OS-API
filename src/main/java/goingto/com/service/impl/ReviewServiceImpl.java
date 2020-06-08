package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Language;
import goingto.com.model.Locatable;
import goingto.com.model.Review;
import goingto.com.model.User;
import goingto.com.repository.LocatableRepository;
import goingto.com.repository.ReviewRepository;
import goingto.com.repository.UserRepository;
import goingto.com.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public List<Review> getAllReviewsByUserId(Integer userId) {
        return reviewRepository.getByUserId(userId);
    }

    @Override
    public List<Review> getAllReviewsByLocatableId(Integer locatableId) {
        return reviewRepository.getByLocatableId(locatableId);
    }

    @Override
    public Review getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Integer reviewId, Review reviewDetails) {
        return reviewRepository.findById(reviewId).map(review -> {
            review.setComment(reviewDetails.getComment());
            review.setReviewedAt(reviewDetails.getReviewedAt());
            review.setStars(reviewDetails.getStars());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }

    @Override
    public ResponseEntity<?> deleteReview(Integer reviewId) {
        return reviewRepository.findById(reviewId).map(Language -> {
            reviewRepository.delete(Language);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }
}
