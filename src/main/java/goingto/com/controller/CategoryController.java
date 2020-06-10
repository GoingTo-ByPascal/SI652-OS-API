package goingto.com.controller;

import goingto.com.model.geographic.Category;
import goingto.com.resource.geographic.CategoryResource;
import goingto.com.resource.geographic.SaveCategoryResource;
import goingto.com.resource.converter.CategoryConverter;
import goingto.com.service.CategoryService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("Return all Categories")
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);

    }

    @ApiOperation("Return Category by id")
    @GetMapping("/categories/{id}")
    public CategoryResource getCategoryById(@PathVariable(name = "id") Integer categoryId) {
        return mapper.convertToResource(categoryService.getCategoryById(categoryId));
    }


    @ApiOperation("Create new Category")
    @PostMapping("/categories")
    public CategoryResource createCategory(@Valid @RequestBody SaveCategoryResource resource) {
        return mapper.convertToResource(categoryService.createCategory(mapper.convertToEntity(resource)));
    }
    @ApiOperation("Update existing Category by id")
    @PutMapping("/categories/{id}")
    public CategoryResource updateTag(@PathVariable(name = "id") Integer categoryId, @Valid @RequestBody SaveCategoryResource resource) {
        return mapper.convertToResource(categoryService.updateCategory(categoryId, mapper.convertToEntity(resource)));
    }

    @ApiOperation("Delete existing Category by id")
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Integer CategoryId) {
        return categoryService.deleteCategory(CategoryId);
    }
}
