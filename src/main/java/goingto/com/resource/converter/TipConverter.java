package goingto.com.resource.converter;

import goingto.com.model.Review;
import goingto.com.model.Tip;
import goingto.com.resource.ReviewResource;
import goingto.com.resource.SaveReviewResource;
import goingto.com.resource.SaveTipResource;
import goingto.com.resource.TipResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipConverter {

    private final ModelMapper modelMapper;

    public Tip convertToEntity(SaveTipResource resource) { return modelMapper.map(resource, Tip.class);
    }

    public TipResource convertToResource(Tip entity) {
        return modelMapper.map(entity, TipResource.class);
    }
}
