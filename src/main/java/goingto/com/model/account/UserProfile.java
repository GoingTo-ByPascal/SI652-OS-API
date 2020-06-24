package goingto.com.model.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.User;
import goingto.com.model.geographic.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name",length = 100)
    private String name;

    @NotEmpty
    @Column(name = "surname",length = 100)
    private String surname;

    @Column(name = "birth_date",length = 12)
    private Date birthdate;

    @NotEmpty
    @Column(name = "gender")
    private String gender;

    @Column(name = "created_at", length = 12)
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
