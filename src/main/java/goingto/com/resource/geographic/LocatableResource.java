package goingto.com.resource.geographic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocatableResource {
    public String address;
    public String description;
    public Float latitude;
    public Float longitude;
}
