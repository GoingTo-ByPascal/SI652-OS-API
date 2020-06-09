package goingto.com.service;

import java.util.List;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Country;

public interface CityService {
	City getCity(Integer id);
	List<City> listAllCities();
	List<City> findByCountry(Country country);
	
}
