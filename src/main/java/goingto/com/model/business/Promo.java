package goingto.com.model.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Locatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Locale;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="promos")
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "text",length = 45)
    private String text;

    @NotEmpty
    @Column(name = "discount")
    private Float discount;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "promos")
    @JsonIgnore
    private List<Locatable> locatables;

}
