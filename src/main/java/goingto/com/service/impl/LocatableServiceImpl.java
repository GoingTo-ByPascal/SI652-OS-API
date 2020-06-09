package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.geographic.Locatable;
import goingto.com.repository.LocatableRepository;
import goingto.com.service.LocatableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatableServiceImpl implements LocatableService {

    @Autowired
    private LocatableRepository locatableRepository;

    @Override
    public Locatable getLocatable(Integer locatableId) {
        return locatableRepository.findById(locatableId)
                .orElseThrow(() -> new ResourceNotFoundException("City", "Id", locatableId));
    }

    @Override
    public List<Locatable> listAllLocatables() {
        return locatableRepository.findAll();
    }
}
