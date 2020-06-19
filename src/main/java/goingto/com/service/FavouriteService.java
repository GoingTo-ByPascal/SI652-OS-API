package goingto.com.service;

import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Locatable;

import java.util.List;

public interface FavouriteService {
    List<Locatable> getByUserId(Integer userId);
    Favourite createFavourite(Favourite favourite);
    Favourite getByUserIdAndLocatableId(Integer userId, Integer locatableId);
    void deleteFavourite(Favourite favourite);
}
