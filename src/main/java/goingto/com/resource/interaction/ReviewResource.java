package goingto.com.resource.interaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResource {
    Integer id;
    Integer userId;
    Integer locatableId;
    public String comment;
    public float stars;
}
