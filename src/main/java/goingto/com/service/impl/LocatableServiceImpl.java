package goingto.com.service.impl;

import goingto.com.model.Locatable;
import goingto.com.repository.LocatableRepository;
import goingto.com.service.LocatableService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocatableServiceImpl implements LocatableService {
    @Autowired
    LocatableRepository locatableRepository;

    @Override
    public Locatable getLocatable(Integer id) {
        return locatableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Locatable> listAllLocatables() {
        return locatableRepository.findAll();
    }
}
