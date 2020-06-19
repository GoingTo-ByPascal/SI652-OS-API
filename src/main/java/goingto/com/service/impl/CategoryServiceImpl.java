package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.geographic.Category;
import goingto.com.repository.geographic.CategoryRepository;
import goingto.com.repository.geographic.PlaceRepository;
import goingto.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllCategoriesByPlaceId(Integer placeId) {
        return placeRepository.findById(placeId).map(place -> {
            List<Category> categories = place.getCategories();
            return categories;
        }).orElseThrow(() -> new ResourceNotFoundException("Place", "Id",placeId));
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer categoryId, Category categoryDetails) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).map(category -> {
            categoryRepository.delete(category);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
    }

}