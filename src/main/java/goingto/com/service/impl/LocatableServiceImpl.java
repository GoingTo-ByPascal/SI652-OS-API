package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.geographic.Locatable;
import goingto.com.model.geographic.Place;
import goingto.com.repository.account.UserRepository;
import goingto.com.repository.geographic.LocatableRepository;
import goingto.com.service.LocatableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatableServiceImpl implements LocatableService {

    @Autowired
    private LocatableRepository locatableRepository;

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
        return userRepository.findById(userId).map(user -> {
            List<Locatable> locatables = user.getLocatables();
            return locatables;
        }).orElseThrow(() -> new ResourceNotFoundException("User", "Id",userId));
    }


}
