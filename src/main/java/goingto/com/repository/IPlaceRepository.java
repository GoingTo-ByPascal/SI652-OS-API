package goingto.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.City;
import goingto.com.model.Place;

public interface IPlaceRepository extends JpaRepository<Place, Long> {
	List<Place> findAllByCity(City city);
}
