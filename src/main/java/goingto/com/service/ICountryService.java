package goingto.com.service;

import java.util.List;

import goingto.com.model.Country;

public interface ICountryService {

	Country getCountry(Integer id);
	List<Country> listAllCountries();
	
	
}
