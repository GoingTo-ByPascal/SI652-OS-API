package goingto.com.repository;

import goingto.com.model.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatableRepository extends JpaRepository<Locatable, Integer> {
}
