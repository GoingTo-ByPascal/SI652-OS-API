package goingto.com.resource.converter;

import goingto.com.model.business.Estate;
import goingto.com.model.geographic.Currency;
import goingto.com.resource.business.EstateResource;
import goingto.com.resource.business.SaveEstateResource;
import goingto.com.resource.geographic.CurrencyResource;
import goingto.com.resource.geographic.SaveCurrencyResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstateConverter {

    private final ModelMapper modelMapper;

    public Estate convertToEntity(SaveEstateResource resource) {
        return modelMapper.map(resource, Estate.class);
    }

    public EstateResource convertToResource(Estate entity) { return modelMapper.map(entity, EstateResource.class);
    }
}
