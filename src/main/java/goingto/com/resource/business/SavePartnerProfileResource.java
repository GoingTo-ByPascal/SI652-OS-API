package goingto.com.resource.business;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SavePartnerProfileResource {
    @NotNull
    @NotBlank
    @Size(max = 45)
    private String name;

    @NotNull
    Integer telephone;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String address;
}
