package goingto.com.service;

import java.util.List;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Place;

public interface CityService {
	City getCity(Integer id);
	List<City> listAllCities();
	List<City> getAllCitiesByCountryId(Integer countryId);
	List<City> getAllCitiesByLocatableId(Integer locatableId);
	
}
