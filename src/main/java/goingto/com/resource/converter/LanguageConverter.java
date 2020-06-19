package goingto.com.resource.converter;

import goingto.com.model.geographic.Language;
import goingto.com.resource.geographic.LanguageResource;
import goingto.com.resource.geographic.SaveLanguageResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LanguageConverter {

    private final ModelMapper modelMapper;

    public Language convertToEntity(SaveLanguageResource resource) { return modelMapper.map(resource, Language.class);
    }

    public LanguageResource convertToResource(Language entity) { return modelMapper.map(entity, LanguageResource.class);
    }

}
