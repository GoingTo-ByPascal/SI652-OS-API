package goingto.com.resource.geographic;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveLocatableResource {

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String description;

    @NotNull
    @NotBlank
    private Float latitude;

    @NotNull
    @NotBlank
    private Float longitude;
}
