package goingto.com.resource.converter;

import goingto.com.model.geographic.Language;
import goingto.com.model.geographic.Locatable;
import goingto.com.resource.geographic.LanguageResource;
import goingto.com.resource.geographic.LocatableResource;
import goingto.com.resource.geographic.SaveLanguageResource;
import goingto.com.resource.geographic.SaveLocatableResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocatableConverter {

    private final ModelMapper modelMapper;

    public Locatable convertToEntity(SaveLocatableResource resource) { return modelMapper.map(resource, Locatable.class);
    }

    public LocatableResource convertToResource(Locatable entity) { return modelMapper.map(entity, LocatableResource.class);
    }
}
