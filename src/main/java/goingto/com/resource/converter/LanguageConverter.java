package goingto.com.resource.converter;

import goingto.com.model.Language;
import goingto.com.resource.LanguageResource;
import goingto.com.resource.SaveLanguageResource;
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
