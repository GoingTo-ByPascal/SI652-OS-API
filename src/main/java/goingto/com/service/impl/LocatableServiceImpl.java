package goingto.com.service.impl;

import goingto.com.model.Locatable;
import goingto.com.repository.LocatableRepository;
import goingto.com.service.LocatableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
public class LocatableServiceImpl implements LocatableService {

    @Autowired
    private LocatableRepository locatableRepository;

    @Override
    public Locatable getLocatable(Integer id) {
        return locatableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Locatable> listAllLocatables() {
        return locatableRepository.findAll();
    }
}
