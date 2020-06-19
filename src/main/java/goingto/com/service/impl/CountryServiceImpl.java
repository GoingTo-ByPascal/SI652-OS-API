package goingto.com.service.impl;

import java.util.List;

import goingto.com.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.geographic.Country;
import goingto.com.repository.geographic.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements goingto.com.service.CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public List<Country> getAllCountriesByLocatableId(Integer locatableId) {
		return countryRepository.findAllByLocatableId(locatableId);
	}

	@Override
	public Country getCountryById(Integer countryId) {
		return countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException("Country", "Id", countryId));
	}


}
