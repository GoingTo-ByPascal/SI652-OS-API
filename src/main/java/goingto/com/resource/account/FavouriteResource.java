package goingto.com.resource.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavouriteResource {
    Integer id;
    Integer userId;
    Integer locatableId;
    public String description;
}
