package goingto.com.repository.account;

import goingto.com.model.account.Favourite;
import goingto.com.model.geographic.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
    List<Favourite> getByUserId(Integer userId);
}
