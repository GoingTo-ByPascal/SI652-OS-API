package goingto.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Place;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
	List<Place> findAllByCity(City city);
}
