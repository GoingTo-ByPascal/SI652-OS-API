package goingto.com.repository.geographic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.Place;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
	List<Place> findAllByCityId(Integer cityId);
	List<Place> findAllByLocatableId(Integer locatableId);
}
