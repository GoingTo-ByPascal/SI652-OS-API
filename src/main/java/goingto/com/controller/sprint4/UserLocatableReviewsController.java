package goingto.com.controller.sprint4;

import goingto.com.model.interaction.Review;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.resource.converter.TipConverter;
import goingto.com.resource.interaction.SaveReviewResource;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.service.LocatableService;
import goingto.com.service.ReviewService;
import goingto.com.service.TipService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserLocatableReviewsController {

    @Autowired
    private UserService userService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewConverter mapper;

    @ApiOperation("Create Tips by User id and Locatable id")
    @PostMapping("/users/{userId}/locatables/{locatableId}/reviews")
    public ResponseEntity<?> createReview(@PathVariable Integer userId, @PathVariable Integer locatableId, @Valid @RequestBody SaveReviewResource resource) {

        var existingUser = userService.getUserById(userId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        var review = mapper.convertToEntity(resource);
        review.setLocatable(existingLocatable);
        review.setUser(existingUser);
        var result = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

   /* @ApiOperation("Update Tips by User id and Locatable id")
    @PutMapping("/users/{userId}/locatables/{locatableId}/tips")*/

    @ApiOperation("Update Tips by User id and Locatable id")
    @GetMapping("/users/{userId}/locatables/{locatableId}/reviews")
    public List<Review> getReviewByUserIdAndLocatableId(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "locatableId") Integer locatableId){
        return reviewService.getByUserIdAndLocatableId(userId, locatableId);
    }

    @ApiOperation("Delete Reviews by User id and Locatable id")
    @DeleteMapping("/users/{userId}/locatables/{locatableId}/reviews")
    public void deleteReviewByUserIdAndLocatableId (@PathVariable(name = "userId") Integer userId, @PathVariable(name = "locatableId") Integer locatableId)
    {
        List<Review> reviews = reviewService.getByUserIdAndLocatableId(userId,locatableId);
        var currentReview = new Review();
        for (int i = 0 ; i < reviews.size(); i++){

            currentReview = reviews.get(i);
            reviewService.deleteReview(currentReview.getId());
        }
    }
}
