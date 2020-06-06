package goingto.com.service.impl;

import java.util.List;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.Language;
import goingto.com.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import goingto.com.model.Country;
import goingto.com.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
	public Country getCountryById(Integer countryId) {
		return countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException("Country", "Id", countryId));
	}


}
