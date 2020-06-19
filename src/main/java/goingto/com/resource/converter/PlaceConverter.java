package goingto.com.resource.converter;

import goingto.com.model.geographic.Locatable;
import goingto.com.model.geographic.Place;
import goingto.com.resource.geographic.LocatableResource;
import goingto.com.resource.geographic.PlaceResource;
import goingto.com.resource.geographic.SaveLocatableResource;
import goingto.com.resource.geographic.SavePlaceResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaceConverter {

    private final ModelMapper modelMapper;

    public Place convertToEntity(SavePlaceResource resource) { return modelMapper.map(resource, Place.class);
    }

    public PlaceResource convertToResource(Place entity) { return modelMapper.map(entity, PlaceResource.class);
    }
}
