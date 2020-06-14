package goingto.com.resource.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Setter
public class UserProfileResource {

    private String name;

    private String surname;

    private Instant birthdate;

    private String gender;

    private Instant createdAt;
}
