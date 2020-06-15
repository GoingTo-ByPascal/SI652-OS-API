package goingto.com.resource.converter;

import goingto.com.model.business.Estate;
import goingto.com.model.business.EstateService;
import goingto.com.resource.business.EstateResource;
import goingto.com.resource.business.EstateServiceResource;
import goingto.com.resource.business.SaveEstateResource;
import goingto.com.resource.business.SaveEstateServiceResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstateServiceConverter {

    private final ModelMapper modelMapper;

    public EstateService convertToEntity(SaveEstateServiceResource resource) { return modelMapper.map(resource, EstateService.class);
    }

    public EstateServiceResource convertToResource(EstateService entity) { return modelMapper.map(entity, EstateServiceResource.class); }
}
