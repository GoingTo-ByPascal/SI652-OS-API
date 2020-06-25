package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Locatable;
import goingto.com.repository.account.FavouriteRepository;
import goingto.com.repository.account.UserRepository;
import goingto.com.repository.geographic.LocatableRepository;
import goingto.com.service.LocatableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocatableServiceImpl implements LocatableService {

    @Autowired
    private LocatableRepository locatableRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Locatable getLocatable(Integer locatableId) {
        return locatableRepository.findById(locatableId)
                .orElseThrow(() -> new ResourceNotFoundException("City", "Id", locatableId));
    }

    @Override
    public Locatable getLocatableByAddress(String address) {
        return locatableRepository.findByAddress(address);
    }

    @Override
    public List<Locatable> listAllLocatables() {
        return locatableRepository.findAll();
    }

    @Override
    public List<Locatable> getAllLocatablesByUserId(Integer userId) {
        var favourites = favouriteRepository.getByUserId(userId);
        List<Locatable> locatables = new ArrayList<>();
        var currentLocatable = new Locatable();
        for(int i=0;i<favourites.size();i++)
        {
         var currentFav = favouriteRepository.findById(favourites.get(i).getId());
         locatables.add(currentFav.get().getLocatable());
        }
        return locatables;
    }


}
