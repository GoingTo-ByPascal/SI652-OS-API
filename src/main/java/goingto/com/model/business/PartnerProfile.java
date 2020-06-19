package goingto.com.model.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "partner_profiles")
public class PartnerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name",length = 45)
    private String name;

    @NotEmpty
    @Column(name = "telephone",length = 45)
    private String telephone;

    @NotEmpty
    @Column(name = "email", length = 45)
    private String email;

    @NotEmpty
    @Column(name = "address", length = 45)
    private String address;

    @OneToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    Partner partner;
}
