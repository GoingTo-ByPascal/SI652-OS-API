package goingto.com.resource.account;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveFavouriteResource {
    @NotNull
    @NotBlank
    @Size(max = 45)
    private String description;
}
