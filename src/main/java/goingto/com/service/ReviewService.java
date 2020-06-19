package goingto.com.service;

import goingto.com.model.account.Favourite;
import goingto.com.model.interaction.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();
    List<Review> getAllReviewsByUserId(Integer userId);
    List<Review> getAllReviewsByLocatableId(Integer locatableId);
    List<Review> getByUserIdAndLocatableId(Integer userId, Integer locatableId);
    Review getReviewById(Integer reviewId);
    Review createReview(Review review);
    Review updateReview(Integer reviewId, Review reviewDetails);
    ResponseEntity<?> deleteReview(Integer reviewId);
}
