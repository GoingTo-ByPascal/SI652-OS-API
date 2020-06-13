package goingto.com.resource.geographic;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveCityResource {
    @NotBlank
    @NotNull
    @Size(max=45)
    public String name;
}
