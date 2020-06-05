package goingto.com.service;

import java.util.List;

import goingto.com.model.City;
import goingto.com.model.Place;

public interface IPlaceService {
	Place getPlace(Integer id);
	List<Place> listAllPlaces();
	List<Place> listAllCitiesByCity(City city);
	Place save(Place place);
	Place edit(Place place, Integer id);
	void deleteById(Integer id);
}
