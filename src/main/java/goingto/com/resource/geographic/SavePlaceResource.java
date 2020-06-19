package goingto.com.resource.geographic;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SavePlaceResource {
    @NotNull
    @NotBlank
    @Size(max = 45)
    private String name;

    @NotNull
    @NotBlank
    private Integer stars;
}
