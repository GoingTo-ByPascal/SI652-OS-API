package goingto.com.service;

import goingto.com.model.geographic.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    List<Category> getAllCategoriesByPlaceId(Integer placeId);
    Category getCategoryById(Integer categoryId);
    Category createCategory(Category category);
    Category updateCategory(Integer categoryId, Category categoryDetails);
    ResponseEntity<?> deleteCategory(Integer categoryId);
}
