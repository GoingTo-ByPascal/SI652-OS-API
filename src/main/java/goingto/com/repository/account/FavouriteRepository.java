package goingto.com.repository.account;

import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
    List<Favourite> getByUserId(Integer userId);
    Optional<Favourite> findByUserIdAndLocatableId(Integer userId, Integer locatableId);
}
