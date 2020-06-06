package goingto.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
}
