package goingto.com.service;

import java.util.List;

import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Locatable;

public interface CountryService {

	Country getCountryById(Integer id);
	List<Country> getAllCountries();
	Country getCountryByLocatableId(Integer locatableId);
	
}
