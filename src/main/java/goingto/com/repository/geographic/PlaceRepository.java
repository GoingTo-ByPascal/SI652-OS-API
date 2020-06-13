package goingto.com.repository.geographic;

import java.util.List;

import goingto.com.model.geographic.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Place;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
	List<Place> findAllByCity(Integer cityId);
	List<Place> findAllByLocatableId(Integer locatableId);
}
