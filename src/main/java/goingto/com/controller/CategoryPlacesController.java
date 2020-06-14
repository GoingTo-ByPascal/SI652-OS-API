package goingto.com.controller;

import goingto.com.model.geographic.Category;
import goingto.com.resource.converter.PlaceConverter;
import goingto.com.service.CategoryService;
import goingto.com.service.PlaceService;
import io.swagger.annotations.ApiOperation;
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
public class CategoryPlacesController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    PlaceService placeService;

    @Autowired
    PlaceConverter mapper;

    @ApiOperation("Return Places by Category id")
    @GetMapping("/categories/{categoryId}/places")
    public ResponseEntity<?> getAllPlacesByCategoryId(@PathVariable(name = "categoryId") Integer categoryId) {
        Category existingCategory = categoryService.getCategoryById(categoryId);
        if(existingCategory==null)
            return ResponseEntity.notFound().build();
        var places = placeService.getAllPlacesByCategoryId(categoryId);
        var result = places.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }


}
