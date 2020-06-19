package goingto.com.model.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="plan_benefits")
public class PlanBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "start_date")
    Instant startDate;

    @NotEmpty
    @Column(name = "end_date")
    Instant endDate;

    @ManyToOne
    @JoinColumn(name = "benefit_id")
    @JsonIgnore
    private Benefit benefit;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @JsonIgnore
    private Plan plan;
}
