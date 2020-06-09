package goingto.com.service;

import goingto.com.model.geographic.Locatable;

import java.util.List;

public interface LocatableService {

    Locatable getLocatable(Integer id);
    List<Locatable> listAllLocatables();
}
