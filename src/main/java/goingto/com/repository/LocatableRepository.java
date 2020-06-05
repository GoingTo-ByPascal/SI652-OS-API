package goingto.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.jdi.Locatable;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatableRepository extends JpaRepository<Locatable, Integer> {
}
