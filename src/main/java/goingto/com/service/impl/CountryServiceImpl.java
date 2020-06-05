package goingto.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.Country;
import goingto.com.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements goingto.com.service.CountryService {

	@Autowired
	private CountryRepository countryRepository;
	@Override
	public Country getCountry(Integer id) {
		return countryRepository.findById(id).orElse(null);
	}

	@Override
	public List<Country> listAllCountries() {
		return countryRepository.findAll();
	}

}
