package goingto.com.resource.converter;

import goingto.com.model.geographic.City;
import goingto.com.resource.geographic.CityResource;
import goingto.com.resource.geographic.SaveCityResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityConverter {

    private final ModelMapper modelMapper;

    public City convertToEntity(SaveCityResource resource) { return modelMapper.map(resource, City.class);
    }

    public CityResource convertToResource(City entity) {
        return modelMapper.map(entity, CityResource.class);
    }
}
