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
	@Autowired
	private LanguageRepository languageRepository;
	@Override
	public Country getCountry(Integer id) {
		return countryRepository.findById(id).orElse(null);
	}

	@Override
	public List<Country> listAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country assignCountryLanguage(Integer countryId, Integer languageId) {
		Language language = languageRepository.findById(languageId)
				.orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
		return countryRepository.findById(countryId).map(post -> {
			if(!post.getLanguages().contains(language)) {
				post.getLanguages().add(language);
				return countryRepository.save(post);
			}
			return post;
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", countryId));
	}

	@Override
	public Country unassignCountryLanguage(Integer countryId, Integer languageId) {
		Language language = languageRepository.findById(languageId)
				.orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
		return countryRepository.findById(countryId).map(country -> {
			country.getLanguages().remove(language);
			return countryRepository.save(country);
		}).orElseThrow(() -> new ResourceNotFoundException("Country", "Id", countryId));
	}

	@Override
	public Page<Country> getAllCountriesByLanguageId(Integer languageId, Pageable pageable) {
		return languageRepository.findById(languageId).map(language -> {
			List<Country> countries = language.getCountries();
			int countriesCount = countries.size();
			return new PageImpl<>(countries, pageable, countriesCount);
		})
				.orElseThrow(() -> new ResourceNotFoundException("Language", "Id", languageId));
	}

}
