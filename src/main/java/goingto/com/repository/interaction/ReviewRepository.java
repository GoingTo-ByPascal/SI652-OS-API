package goingto.com.repository.interaction;

import goingto.com.model.interaction.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> getByUserProfileId(Integer userId);
    List<Review> getByLocatableId(Integer locatableId);
    List<Review> findByUserProfileIdAndLocatableId(Integer userProfileId, Integer LocatableId);
}
