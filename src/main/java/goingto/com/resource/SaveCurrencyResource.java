package goingto.com.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class SaveCurrencyResource {
    @NotNull
    @NotBlank
    @Size(max = 3)
    @Column(unique = true)
    private String shortName;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String unit;
}
