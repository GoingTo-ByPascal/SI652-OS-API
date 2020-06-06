package goingto.com.repository;

import goingto.com.model.City;
import goingto.com.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipRepository extends JpaRepository<Tip, Integer> {
}
