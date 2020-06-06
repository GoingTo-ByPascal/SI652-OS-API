package goingto.com.service;

import java.util.List;

import goingto.com.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {

	Country getCountryById(Integer id);
	List<Country> getAllCountries();
	
}
