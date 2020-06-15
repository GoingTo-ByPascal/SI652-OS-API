package goingto.com.resource.converter;

import goingto.com.model.business.PartnerProfile;
import goingto.com.model.geographic.Locatable;
import goingto.com.resource.business.PartnerProfileResource;
import goingto.com.resource.business.SavePartnerProfileResource;
import goingto.com.resource.geographic.LocatableResource;
import goingto.com.resource.geographic.SaveLocatableResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerProfileConverter {

    private final ModelMapper modelMapper;

    public PartnerProfile convertToEntity(SavePartnerProfileResource resource) { return modelMapper.map(resource, PartnerProfile.class);
    }

    public PartnerProfileResource convertToResource(PartnerProfile entity) { return modelMapper.map(entity, PartnerProfileResource.class);
    }
}
