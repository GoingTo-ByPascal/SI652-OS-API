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
@Table(name="tips")
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "text",length = 100)
    private String text;

    @ManyToOne
    @JoinColumn(name = "locatable_id")
    private Locatable locatable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
