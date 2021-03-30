package goingto.com.resource.interaction;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ReviewResource {
    Integer id;
    Integer userId;
    Integer locatableId;
    Instant reviewedAt;
    public String comment;
    public float stars;
}
