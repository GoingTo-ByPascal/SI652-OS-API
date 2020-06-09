package goingto.com.model.interaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.geographic.Locatable;
import goingto.com.model.account.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locatable_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Locatable locatable;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}