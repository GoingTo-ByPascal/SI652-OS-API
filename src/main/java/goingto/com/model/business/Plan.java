package goingto.com.model.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.Favourite;
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
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name", length = 45)
    private String name;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    List<PlanUser> planUsers;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    List<PlanBenefit> planBenefits;
}
