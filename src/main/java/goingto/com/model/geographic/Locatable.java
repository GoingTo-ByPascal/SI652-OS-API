package goingto.com.model.geographic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.User;
import goingto.com.model.business.Promo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "locatables")
public class Locatable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "address",length = 100)
    private String address;

    @NotEmpty
    @Column(name = "description",length = 100)
    private String description;

    @NotEmpty
    @Column(name = "latitude")
    private Float latitude;

    @NotEmpty
    @Column(name = "longitude")
    private Float longitude;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "locatable_promos",
            joinColumns = {@JoinColumn(name = "locatable_id")},
            inverseJoinColumns = {@JoinColumn(name = "promo_id")})
    @JsonIgnore
    private List<Promo> promos;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "locatables")
    @JsonIgnore
    private List<User> users;

}