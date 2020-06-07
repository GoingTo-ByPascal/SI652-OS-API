package goingto.com.service;

import goingto.com.model.Locatable;
import goingto.com.model.Review;
import goingto.com.model.Tip;
import goingto.com.model.User;

import java.util.List;

public interface TipService {

    Tip getTip(Integer id);
    List<Tip> listAllTips();
    List<Tip> getByUserId(User user);
    List<Tip> getByLocatableId(Locatable locatable);
    Tip save(Tip tip);
    void delete (int id);
}
