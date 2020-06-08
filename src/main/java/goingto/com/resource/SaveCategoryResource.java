package goingto.com.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter@Setter
public class SaveCategoryResource {

    @NotBlank
    @NotNull
    @Size(max=45)
    public String name;
}
