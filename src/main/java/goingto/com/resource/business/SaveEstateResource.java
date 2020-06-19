package goingto.com.resource.business;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveEstateResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;
}
