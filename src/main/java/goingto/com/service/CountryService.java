package goingto.com.service;

import java.util.List;

import goingto.com.model.geographic.Country;

public interface CountryService {

	Country getCountryById(Integer id);
	List<Country> getAllCountries();
	
}
