package goingto.com.resource.business;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SavePromoResource {
    @NotNull
    @NotBlank
    @Size(max = 45)
    private String text;

    @NotNull
    @NotBlank
    private Float discount;
}
