package goingto.com.service;

import java.util.List;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Place;

public interface PlaceService {
	Place getPlace(Integer id);
	List<Place> listAllPlaces();
	List<Place> listAllPlacesByCity(City city);
	Place save(Place place);
	Place edit(Place place, Integer id);
	void deleteById(Integer id);
}
