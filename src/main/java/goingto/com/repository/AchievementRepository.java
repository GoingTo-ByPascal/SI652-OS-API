package goingto.com.repository;

import goingto.com.model.Achievement;
import goingto.com.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Integer> {
}
