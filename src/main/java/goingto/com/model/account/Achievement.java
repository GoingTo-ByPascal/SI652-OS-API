package goingto.com.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.User;
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
@Table(name = "achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name",length = 100)
    private String name;

    @NotEmpty
    @Column(name = "text",length = 100)
    private String text;

    @NotEmpty
    @Column(name = "points")
    private Integer points;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "achievements")
    @JsonIgnore
    private List<User> users;
}
