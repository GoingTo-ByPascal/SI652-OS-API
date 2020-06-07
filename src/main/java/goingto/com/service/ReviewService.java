package goingto.com.service;

import goingto.com.model.Locatable;
import goingto.com.model.Review;
import goingto.com.model.User;

import java.util.List;

public interface ReviewService {

    Review getReview(Integer id);
    List<Review> listAllReviews();
    List<Review> getByUserId(User user);
    List<Review> getByLocatableId(Locatable locatable);
    Review save(Review review);
    void delete (int id);
}
