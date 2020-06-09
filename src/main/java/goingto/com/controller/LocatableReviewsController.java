package goingto.com.controller;

import goingto.com.model.geographic.Locatable;
import goingto.com.resource.converter.ReviewConverter;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.ReviewService;
import goingto.com.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

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

    @GetMapping("/locatables/{locatableId}/reviews")
    public ResponseEntity<?> getAllReviewsByLocatableId(@PathVariable Integer locatableId){
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        var reviews = reviewService.getAllReviewsByLocatableId(locatableId);
        var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
