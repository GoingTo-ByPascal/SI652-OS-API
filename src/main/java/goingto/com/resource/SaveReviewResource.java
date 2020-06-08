package goingto.com.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveReviewResource {
    @NotNull
    @NotBlank
    @Size(max = 45)
    private String comment;

    @NotNull
    @NotBlank
    private Integer stars;

    @NotNull
    @NotBlank
    @Size(max = 12)
    private String reviewedAt;
}
