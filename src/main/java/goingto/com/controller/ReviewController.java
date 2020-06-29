package goingto.com.controller;

import goingto.com.model.interaction.Review;
import goingto.com.resource.interaction.ReviewResource;
import goingto.com.resource.interaction.SaveReviewResource;
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
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<List<ReviewResource>> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews = reviewService.getAllReviews();
        var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);

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
    public ResponseEntity<ReviewResource> updateReview(@PathVariable(name = "id") Integer ReviewId, @Valid @RequestBody SaveReviewResource resource) {
        return ResponseEntity.ok(
                mapper.convertToResource(reviewService.updateReview(ReviewId, mapper.convertToEntity(resource))));
    }

    @ApiOperation("Delete existing Review by id")
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<ReviewResource> deleteReview(@PathVariable(name = "id") Integer ReviewId) {
        return  ResponseEntity.ok(mapper.convertToResource(reviewService.deleteReview(ReviewId)));
    }



}
