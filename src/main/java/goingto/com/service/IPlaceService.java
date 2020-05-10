package goingto.com.service;

import java.util.List;

import goingto.com.model.City;
import goingto.com.model.Place;

public interface IPlaceService {
	Place getPlace(Long id);
	List<Place> listAllPlaces();
	List<Place> listAllCitiesByCity(City city);
	Place save(Place place);
	Place edit(Place place, Long id);
	void deleteById(Long id);
}
