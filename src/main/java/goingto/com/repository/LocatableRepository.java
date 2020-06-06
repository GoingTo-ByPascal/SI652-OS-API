package goingto.com.repository;

import goingto.com.model.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatableRepository extends JpaRepository<Locatable, Integer> {
}
