package goingto.com.model.geographic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.geographic.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotEmpty
    @Column(name = "unit",length = 10)
    public String unit;

    @NotEmpty
    @Column(name = "short_name",length = 10)
    public String shortName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "currencies")
    @JsonIgnore
    private List<Country> countries;
}
