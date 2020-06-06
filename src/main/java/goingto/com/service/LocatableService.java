package goingto.com.service;

import goingto.com.model.Locatable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LocatableService {

    Locatable getLocatable(Integer id);
    List<Locatable> listAllLocatables();
}
