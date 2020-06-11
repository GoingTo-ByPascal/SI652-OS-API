package goingto.com.service;

import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Locatable;

import java.util.List;

public interface FavouriteService {
    /*List<Favourite> getByUserIdVS(Integer userId);*/
    List<Locatable> getByUserId(Integer userId);
}
