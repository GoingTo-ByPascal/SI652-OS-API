package goingto.com.resource.converter;

import goingto.com.model.account.Achievement;
import goingto.com.resource.AchievementResource;
import goingto.com.resource.SaveAchievementResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AchievementConverter {

    private final ModelMapper modelMapper;

    //mapAutomatic
    public AchievementResource convertToResource(Achievement resource) {
        return modelMapper.map(resource, AchievementResource.class);

    }

    public Achievement convertToEntity(SaveAchievementResource resource) {
        return modelMapper.map(resource, Achievement.class);

    }
}
