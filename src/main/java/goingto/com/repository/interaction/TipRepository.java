package goingto.com.repository.interaction;

import goingto.com.model.interaction.Review;
import goingto.com.model.interaction.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipRepository extends JpaRepository<Tip, Integer> {
    List<Tip> getByUserId(Integer id);
    List<Tip> getByLocatableId(Integer id);
    List<Tip> findByUserIdAndLocatableId(Integer userId, Integer LocatableId);
}
