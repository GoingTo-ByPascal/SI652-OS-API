package goingto.com.controller;

import goingto.com.model.interaction.Review;
import goingto.com.resource.ReviewResource;
import goingto.com.resource.SaveReviewResource;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation("Return all Reviews")
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);

    }

    @ApiOperation("Return Review by id")
    @GetMapping("/reviews/{id}")
    public ReviewResource getReviewById(@PathVariable(name = "id") Integer reviewId) {
        return mapper.convertToResource(reviewService.getReviewById(reviewId));
    }

    @ApiOperation("Create new Review")
    @PostMapping("/reviews")
    public ReviewResource createReview(@Valid @RequestBody SaveReviewResource resource) {
        return mapper.convertToResource(reviewService.createReview(mapper.convertToEntity(resource)));
    }

    @ApiOperation("Update existing Review by id")
    @PutMapping("/reviews/{id}")
    public ReviewResource updateReview(@PathVariable(name = "id") Integer ReviewId, @Valid @RequestBody SaveReviewResource resource) {
        return mapper.convertToResource(reviewService.updateReview(ReviewId, mapper.convertToEntity(resource)));
    }

    @ApiOperation("Delete existing Review by id")
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable(name = "id") Integer ReviewId) {
        return reviewService.deleteReview(ReviewId);
    }



}
