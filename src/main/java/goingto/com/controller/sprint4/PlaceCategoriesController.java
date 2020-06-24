package goingto.com.controller.sprint4;

import goingto.com.model.geographic.Category;
import goingto.com.model.geographic.Place;
import goingto.com.resource.converter.CategoryConverter;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PlaceCategoriesController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    PlaceService placeService;

    @Autowired
    CategoryConverter mapper;


    @ApiOperation("Return Categories by Place id")
    @GetMapping("/places/{placeId}/categories")
    public ResponseEntity<List<Category>> getAllCategoriesByPlaceId(@PathVariable(name = "placeId") Integer placeId) {
        Place existingPlace = placeService.getPlace(placeId);
        if(existingPlace==null)
            return ResponseEntity.notFound().build();
        var categories = categoryService.getAllCategoriesByPlaceId(placeId);
        //var result = categories.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

}
