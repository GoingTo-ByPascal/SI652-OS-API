package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Locatable;
import goingto.com.model.Review;
import goingto.com.model.User;
import goingto.com.repository.ReviewRepository;
import goingto.com.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review getReview(Integer reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
    }

    @Override
    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getByUserId(User user) {
        return reviewRepository.getByUserId(user);
    }

    @Override
    public List<Review> getByLocatableId(Locatable locatable) {
        return reviewRepository.getByLocatableId(locatable);
    }

    @Override
    public Review save(Review review) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
