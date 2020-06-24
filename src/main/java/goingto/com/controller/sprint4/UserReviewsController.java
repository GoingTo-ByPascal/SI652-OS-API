package goingto.com.controller.sprint4;

import goingto.com.model.account.User;
import goingto.com.model.account.UserProfile;
import goingto.com.model.interaction.Review;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.service.ReviewService;
import goingto.com.service.UserProfileService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserReviewsController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    ReviewConverter mapper;

    @ApiOperation("Return Reviews by User Profile id")
    @GetMapping("/user_profiles/{userProfileId}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByUserProfileId(@PathVariable(name = "userProfileId") Integer userProfileId){
        var existingUserProfile = userProfileService.getUserProfileById(userProfileId);
        if(existingUserProfile==null)
            return ResponseEntity.notFound().build();
        var reviews = reviewService.getAllReviewsByUserProfileId(userProfileId);
        //var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(reviews);
    }
}
