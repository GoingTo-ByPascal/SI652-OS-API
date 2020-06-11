package goingto.com.controller;

import goingto.com.model.account.User;
import goingto.com.model.geographic.Locatable;
import goingto.com.model.interaction.Review;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.service.ReviewService;
import goingto.com.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserReviewsController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewConverter mapper;

    @ApiOperation("Return Reviews by User id")
    @GetMapping("/users/{userId}/reviews")
    public ResponseEntity<?> getAllReviewsByUserId(@PathVariable(name = "userId") Integer userId){
        User existingUser = userService.getUserById(userId);
        if(existingUser==null)
            return ResponseEntity.notFound().build();
        var reviews = reviewService.getAllReviewsByUserId(userId);
        var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
