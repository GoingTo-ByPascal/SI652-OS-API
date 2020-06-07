package goingto.com.controller;

import goingto.com.model.*;
import goingto.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

   /* @GetMapping
    public ResponseEntity<List<Review>> listReviews(){
        List<Review> reviews = new ArrayList<>();

        reviews = reviewService.listAllReviews();
        if(reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(reviews);
    }*/
/*
    @GetMapping
    public ResponseEntity<List<Review>> listReviewsByLocatable(@RequestParam(name="locatableId",required = false)Integer locatableId){
        List<Review> reviews = new ArrayList<>();
        if(locatableId == null)
        {
            reviews = reviewService.listAllReviews();
            if(reviews.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }
        else {
            reviews=reviewService.getByLocatableId(Locatable.builder().id(locatableId).build());
        }
        return ResponseEntity.ok(reviews);
    }

*/
    @GetMapping("/{id}")
    public ResponseEntity<Review>getById(@PathVariable Integer id)
    {
        Review review = reviewService.getReview(id);
        if(review ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(review));
    }
    @PostMapping
    public ResponseEntity<Review> newReview(@RequestBody Review review)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.save((review)));
    }

    /*@PutMapping
    public ResponseEntity<Place> updatePlace(@RequestBody Place place,@PathVariable Integer id)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(placeService.edit(place, id));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Integer id)
    {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
