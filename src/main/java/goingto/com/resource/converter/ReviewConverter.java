package goingto.com.resource.converter;

import goingto.com.model.interaction.Review;
import goingto.com.resource.interaction.ReviewResource;
import goingto.com.resource.interaction.SaveReviewResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewConverter {

    private final ModelMapper modelMapper;

    public Review convertToEntity(SaveReviewResource resource) { return modelMapper.map(resource, Review.class);
    }

    public ReviewResource convertToResource(Review entity) {
        return modelMapper.map(entity, ReviewResource.class);
    }
}
