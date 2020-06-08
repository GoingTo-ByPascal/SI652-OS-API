package goingto.com.controller;

import goingto.com.model.*;
import goingto.com.resource.ReviewResource;
import goingto.com.resource.SaveReviewResource;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewConverter mapper;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);

    }

    @GetMapping("/reviews/{id}")
    public ReviewResource getReviewById(@PathVariable(name = "id") Integer reviewId) {
        return mapper.convertToResource(reviewService.getReviewById(reviewId));
    }

    @GetMapping("/locatables/{locatableId}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByLocatableId(@PathVariable(name = "locatableId") Integer locatableId) {
        List<Review> reviews = new ArrayList<>();
        reviews = reviewService.getAllReviewsByLocatableId(locatableId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/users/{userId}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByUserId(@PathVariable(name = "userId") Integer userId){
        List<Review> reviews = new ArrayList<>();
        reviews=reviewService.getAllReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/reviews")
    public ReviewResource createReview(@Valid @RequestBody SaveReviewResource resource) {
        return mapper.convertToResource(reviewService.createReview(mapper.convertToEntity(resource)));
    }
    @PutMapping("/reviews/{id}")
    public ReviewResource updateTag(@PathVariable(name = "id") Integer ReviewId, @Valid @RequestBody SaveReviewResource resource) {
        return mapper.convertToResource(reviewService.updateReview(ReviewId, mapper.convertToEntity(resource)));
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable(name = "id") Integer ReviewId) {
        return reviewService.deleteReview(ReviewId);
    }



}
