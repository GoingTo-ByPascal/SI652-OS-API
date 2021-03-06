package goingto.com.resource.converter;

import goingto.com.model.geographic.Country;
import goingto.com.resource.geographic.CountryResource;
import goingto.com.resource.geographic.SaveCountryResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryConverter {

    private final ModelMapper modelMapper;

    public Country convertToEntity(SaveCountryResource resource) { return modelMapper.map(resource, Country.class);
    }

    public CountryResource convertToResource(Country entity) {
        return modelMapper.map(entity, CountryResource.class);
    }
}
