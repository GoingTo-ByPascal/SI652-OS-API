package goingto.com.resource.converter;

import goingto.com.model.account.UserProfile;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.account.SaveUserProfileResource;
import goingto.com.resource.account.UserProfileResource;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.resource.interaction.TipResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileConverter {

    private final ModelMapper modelMapper;

    public UserProfile convertToEntity(SaveUserProfileResource resource) { return modelMapper.map(resource, UserProfile.class);
    }

    public UserProfileResource convertToResource(UserProfile entity) { return modelMapper.map(entity, UserProfileResource.class);
    }
}
