package goingto.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.Country;
import goingto.com.repository.ICountryRepository;
import goingto.com.service.ICountryService;

public class CountryService implements ICountryService {

	@Autowired
	private ICountryRepository countryRepository;
	@Override
	public Country getCountry(Integer id) {
		return countryRepository.findById(id).orElse(null);
	}

	@Override
	public List<Country> listAllCountries() {
		return countryRepository.findAll();
	}

}
