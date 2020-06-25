package goingto.com.service;

import java.util.List;

import goingto.com.model.geographic.Place;

public interface PlaceService {
	Place getPlace(Integer id);
	List<Place> listAllPlaces();
	List<Place> getAllPlacesByCategoryId (Integer categoryId);
	List<Place> getAllPlacesByCityId(Integer cityId);
	Place getPlaceByLocatableId(Integer locatableId);
	List<Place> getByCategoryIdAndCityId(Integer categoryId, Integer cityId);
	Place save(Place place);
	Place edit(Place place, Integer id);
	void deleteById(Integer id);
}
