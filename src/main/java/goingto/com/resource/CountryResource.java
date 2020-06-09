package goingto.com.resource;

import goingto.com.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryResource {
    public Integer id;
    public String shortName;
    public String fullName;
}
