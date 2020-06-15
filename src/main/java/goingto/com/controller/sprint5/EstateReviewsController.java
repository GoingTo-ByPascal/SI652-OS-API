package goingto.com.controller.sprint5;

import goingto.com.resource.converter.ReviewConverter;
import goingto.com.service.EstateService;
import goingto.com.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EstateReviewsController {
    @Autowired
    EstateService estateService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewConverter mapper;

    @GetMapping("estates/{estateId}/reviews")
    public ResponseEntity<?> getAllReviewsByEstateId(@PathVariable(name = "estateId") Integer estateId) {
        var existingEstate = estateService.getEstateById(estateId);
        var reviews = reviewService.getAllReviewsByLocatableId(existingEstate.getLocatable().getId());
        var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);

    }


}
