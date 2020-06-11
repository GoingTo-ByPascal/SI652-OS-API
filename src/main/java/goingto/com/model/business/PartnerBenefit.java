package goingto.com.model.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "partner_benefits")
public class PartnerBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "start_date", length = 15)
    private Instant startDate;

    @NotEmpty
    @Column(name = "end_date", length = 15)
    private Instant endDate;
}
