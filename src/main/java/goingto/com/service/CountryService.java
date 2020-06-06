package goingto.com.service;

import java.util.List;

import goingto.com.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {

	Country getCountry(Integer id);
	List<Country> listAllCountries();
	Country assignCountryLanguage(Integer countryId, Integer languageId);
	Country unassignCountryLanguage(Integer countryId, Integer languageId);
	Page<Country> getAllCountriesByLanguageId(Integer languageId, Pageable pageable);

	
	
}
