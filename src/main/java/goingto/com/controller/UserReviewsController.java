package goingto.com.controller;

import goingto.com.model.Locatable;
import goingto.com.model.Review;
import goingto.com.model.User;
import goingto.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class UserReviewsController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> listReviewsByUser(@RequestParam(name="userId",required = false)Integer userId){
        List<Review> reviews = new ArrayList<>();
        if(userId == null)
        {
            reviews = reviewService.listAllReviews();
            if(reviews.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }
        else {
            reviews=reviewService.getByUserId(User.builder().id(userId).build());
        }
        return ResponseEntity.ok(reviews);
    }
}
