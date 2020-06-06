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
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "comment",length = 100)
    private String comment;

    @NotEmpty
    @Column(name = "stars")
    private Integer stars;

    @NotEmpty
    @Column(name = "reviewed_at", length = 12)
    private String reviewedAt;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "locatable_id")
    private Locatable locatable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
