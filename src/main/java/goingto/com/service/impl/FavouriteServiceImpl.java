package goingto.com.service.impl;

import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Locatable;
import goingto.com.repository.account.FavouriteRepository;
import goingto.com.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    FavouriteRepository favouriteRepository;


    @Override
    public List<Favourite> getByUserIdVS(Integer userId) {
        return favouriteRepository.getByUserId(userId);
    }

    @Override
    public List<Locatable> getByUserId(Integer userId) {
        return favouriteRepository.findById(userId).map(favourite->{
            List<Locatable> locatables = Collections.singletonList(favourite.getLocatable());
            return locatables;
        }).orElse(null);
    }
}
