package goingto.com.resource.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavouriteResource {
    public Integer id;
    public Integer userId;
    public Integer locatableId;
    public String description;
}
