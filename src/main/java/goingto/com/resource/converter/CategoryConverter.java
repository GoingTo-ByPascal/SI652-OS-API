package goingto.com.resource.converter;

import goingto.com.config.MapperConfig;
import goingto.com.model.Category;
import goingto.com.resource.CategoryResource;
import goingto.com.resource.SaveCategoryResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryConverter {

    private final ModelMapper modelMapper;

    //mapAutomatic
    public CategoryResource convertToResource(Category resource) {
        return modelMapper.map(resource, CategoryResource.class);

    }

    public Category convertToEntity(SaveCategoryResource resource) {
        return modelMapper.map(resource, Category.class);

    }
}