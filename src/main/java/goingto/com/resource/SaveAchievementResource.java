package goingto.com.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveAchievementResource {
    @NotNull
    @NotBlank
    @Size(max = 45)
    private String name;

    @NotNull
    @NotBlank
    private Integer points;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String text;
}
