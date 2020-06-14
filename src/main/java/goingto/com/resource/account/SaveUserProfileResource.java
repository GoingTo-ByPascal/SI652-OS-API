package goingto.com.resource.account;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
public class SaveUserProfileResource {

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String surname;

    @NotNull
    @NotBlank
    private Instant birthdate;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String gender;

    @NotNull
    @NotBlank
    private Instant createdAt;

}
