package goingto.com.model.interaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.UserProfile;
import goingto.com.model.geographic.Locatable;
import goingto.com.model.account.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

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
    private Float stars;

    @NotEmpty
    @Column(name = "reviewed_at", length = 10)
    Instant reviewedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locatable_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Locatable locatable;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_profile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserProfile userProfile;
}
