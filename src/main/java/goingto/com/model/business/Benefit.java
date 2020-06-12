package goingto.com.model.business;

import goingto.com.model.account.PlanUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="benefits")
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name", length = 45)
    private String name;

    @NotEmpty
    @Column(name = "description",length = 100)
    private String description;

    @OneToMany(mappedBy = "benefit")
    List<PlanBenefit> planBenefits;

}
