package goingto.com.resource.converter;

import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Language;
import goingto.com.resource.account.FavouriteResource;
import goingto.com.resource.account.SaveFavouriteResource;
import goingto.com.resource.geographic.LanguageResource;
import goingto.com.resource.geographic.SaveLanguageResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavouriteConverter {

    private final ModelMapper modelMapper;

    public Favourite convertToEntity(SaveFavouriteResource resource) { return modelMapper.map(resource, Favourite.class);
    }

    public FavouriteResource convertToResource(Favourite entity) { return modelMapper.map(entity, FavouriteResource.class);
    }
}
