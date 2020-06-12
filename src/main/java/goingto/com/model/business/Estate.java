package goingto.com.model.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.business.Partner;
import goingto.com.model.business.Service;
import goingto.com.model.geographic.Locatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estates")
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name", length = 45)
    private String name;

    @NotEmpty
    @Column(name = "description", length = 45)
    private String description;

    @OneToOne
    @JoinColumn(name = "locatable_id")
    @JsonIgnore
    private Locatable locatable;


    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    private Partner partner;

    @OneToMany(mappedBy = "estate")
    List<EstateService> estateServices;
}
