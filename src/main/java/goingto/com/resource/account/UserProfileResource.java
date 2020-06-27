package goingto.com.resource.account;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;

@Getter
@Setter
public class UserProfileResource {

    Integer id;

    private String name;

    private String surname;

    private Date birthdate;

    Integer countryId;
    
    Integer userId;

    private String gender;

    private  Instant createdAt;

}
