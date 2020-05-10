package goingto.com.service;

import java.util.List;

import goingto.com.model.Country;

public interface ICountryService {

	Country getCountry(Long id);
	List<Country> listAllCountries();
	
	
}
