package goingto.com.resource.interaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResource {
    public Integer Id;
    public String comment;
    public Integer stars;
    public String reviewedAt;

}
