package goingto.com.repository.geographic;

import goingto.com.model.geographic.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatableRepository extends JpaRepository<Locatable, Integer> {
}
