package goingto.com.repository;

import goingto.com.model.interaction.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> getByUserId(Integer id);
    List<Review> getByLocatableId(Integer id);
}
