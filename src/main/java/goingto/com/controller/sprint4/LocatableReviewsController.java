package goingto.com.controller.sprint4;

import goingto.com.model.geographic.Locatable;
import goingto.com.model.interaction.Review;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.resource.interaction.ReviewResource;
import goingto.com.service.LocatableService;
import goingto.com.service.ReviewService;
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
public class LocatableReviewsController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private LocatableService locatableService;
    @Autowired
    private ReviewConverter mapper;

    @ApiOperation("Return Reviews by Locatable id")
    @GetMapping("/locatables/{locatableId}/reviews")
    public ResponseEntity<List<ReviewResource>> getAllReviewsByLocatableId(@PathVariable Integer locatableId){
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        var reviews = reviewService.getAllReviewsByLocatableId(locatableId);
        var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
