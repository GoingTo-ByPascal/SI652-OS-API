package goingto.com.resource.converter;

import goingto.com.model.business.Promo;
import goingto.com.model.geographic.Language;
import goingto.com.resource.business.PromoResource;
import goingto.com.resource.business.SavePromoResource;
import goingto.com.resource.geographic.LanguageResource;
import goingto.com.resource.geographic.SaveLanguageResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromoConverter {

    private final ModelMapper modelMapper;

    public Promo convertToEntity(SavePromoResource resource) { return modelMapper.map(resource, Promo.class);
    }

    public PromoResource convertToResource(Promo entity) { return modelMapper.map(entity, PromoResource.class);
    }
}
