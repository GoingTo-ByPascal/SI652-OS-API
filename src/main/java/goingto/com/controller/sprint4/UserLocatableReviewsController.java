package goingto.com.controller.sprint4;

import goingto.com.model.interaction.Review;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.resource.converter.TipConverter;
import goingto.com.resource.interaction.ReviewResource;
import goingto.com.resource.interaction.SaveReviewResource;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.service.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserLocatableReviewsController {

    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewConverter mapper;

    @ApiOperation("Create Tips by User id and Locatable id")
    @PostMapping("/user_profiles/{userProfileId}/locatables/{locatableId}/reviews")
    public ResponseEntity<ReviewResource> createReview(@PathVariable Integer userProfileId, @PathVariable Integer locatableId, @Valid @RequestBody SaveReviewResource resource) {

        var existingUserProfile = userProfileService.getUserProfileById(userProfileId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        var review = mapper.convertToEntity(resource);
        review.setLocatable(existingLocatable);
        review.setUserProfile(existingUserProfile);
        var result = mapper.convertToResource(reviewService.createReview(review));
        return ResponseEntity.ok(result);
    }

    /*
    @ApiOperation("Update Tips by User id and Locatable id")
    @PutMapping("/users/{userId}/locatables/{locatableId}/tips")
    public ResponseEntity<ReviewResource> updateReview(@PathVariable Integer userProfileId, @PathVariable Integer locatableId, @Valid @RequestBody SaveReviewResource resource){

        var existingUserProfile = userProfileService.getUserProfileById(userProfileId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        var review = mapper.convertToEntity(resource);
        review.setLocatable(existingLocatable);
        review.setUserProfile(existingUserProfile);

    }

     */

    @ApiOperation("Get Reviews by User id and Locatable id")
    @GetMapping("/user_profiles/{userProfileId}/locatables/{locatableId}/reviews")
    public List<ReviewResource> getReviewByUserIdAndLocatableId(@PathVariable(name = "userProfileId") Integer userProfileId, @PathVariable(name = "locatableId") Integer locatableId){
       var reviews = reviewService.getByUserProfileIdAndLocatableId(userProfileId, locatableId);
        return reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
    }

    @ApiOperation("Delete Reviews by User id and Locatable id")
    @DeleteMapping("/user_profiles/{userProfileId}/locatables/{locatableId}/reviews")
    public void deleteReviewByUserIdAndLocatableId (@PathVariable(name = "userProfileId") Integer userProfileId, @PathVariable(name = "locatableId") Integer locatableId)
    {
        List<Review> reviews = reviewService.getByUserProfileIdAndLocatableId(userProfileId,locatableId);
        var currentReview = new Review();
        for (int i = 0 ; i < reviews.size(); i++){

            currentReview = reviews.get(i);
            reviewService.deleteReview(currentReview.getId());
        }
    }
}
