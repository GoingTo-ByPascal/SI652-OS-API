package goingto.com.service;

import java.util.List;

import goingto.com.model.City;
import goingto.com.model.Country;

public interface ICityService {
	City getCity(Long id);
	List<City> listAllCities();
	List<City> findByCountry(Country country);
	
}
