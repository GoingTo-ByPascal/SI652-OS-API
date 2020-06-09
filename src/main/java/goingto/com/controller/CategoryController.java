package goingto.com.controller;

import goingto.com.model.geographic.Category;
import goingto.com.resource.CategoryResource;
import goingto.com.resource.SaveCategoryResource;
import goingto.com.resource.converter.CategoryConverter;
import goingto.com.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryConverter mapper;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCurrencies() {
        List<Category> categories = new ArrayList<>();
        categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);

    }

    @GetMapping("/categories/{id}")
    public CategoryResource getCategoryById(@PathVariable(name = "id") Integer categoryId) {
        return mapper.convertToResource(categoryService.getCategoryById(categoryId));
    }

    @GetMapping("/places/{placeId}/categories")
    public ResponseEntity<List<Category>> getAllCurrenciesByCountryId(@PathVariable(name = "placeId") Integer placeId) {
        List<Category> categories = new ArrayList<>();
        categories = categoryService.getAllCategoriesByPlaceId(placeId);
        return ResponseEntity.ok(categories);
    }


    @PostMapping("/categories")
    public CategoryResource createCategory(@Valid @RequestBody SaveCategoryResource resource) {
        return mapper.convertToResource(categoryService.createCategory(mapper.convertToEntity(resource)));
    }
    @PutMapping("/categories/{id}")
    public CategoryResource updateTag(@PathVariable(name = "id") Integer categoryId, @Valid @RequestBody SaveCategoryResource resource) {
        return mapper.convertToResource(categoryService.updateCategory(categoryId, mapper.convertToEntity(resource)));
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Integer CategoryId) {
        return categoryService.deleteCategory(CategoryId);
    }
}
