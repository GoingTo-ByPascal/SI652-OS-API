package goingto.com.resource.converter;


import goingto.com.model.geographic.Currency;
import goingto.com.resource.geographic.CurrencyResource;
import goingto.com.resource.geographic.SaveCurrencyResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyConverter {

    private final ModelMapper modelMapper;

    public Currency convertToEntity(SaveCurrencyResource resource) {
        return modelMapper.map(resource, Currency.class);
    }

    public CurrencyResource convertToResource(Currency entity) { return modelMapper.map(entity, CurrencyResource.class);
    }
}


