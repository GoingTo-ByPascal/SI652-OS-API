package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import goingto.com.resource.CountryResource;
import goingto.com.resource.converter.CountryConverter;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import goingto.com.model.Country;
import goingto.com.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private CountryConverter mapper;

	@GetMapping
	public ResponseEntity<List<Country>> listCountry(){
		List<Country> countries = new ArrayList<>();
		
			countries = countryService.listAllCountries();
			if(countries.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
	
		return ResponseEntity.ok(countries);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Country>getById(@PathVariable Integer id)
	{
		Country country = countryService.getCountry(id);
		if(country ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(country));
	}

	@GetMapping("/languages/{languageId}/countries")
	public Page<CountryResource> getAllCountriesByLanguageId(@PathVariable(name = "languageId") Integer languageId, Pageable pageable) {
		Page<Country> countriesPage = countryService.getAllCountriesByLanguageId(languageId, pageable);
		List<CountryResource> resources = countriesPage.getContent().stream().map(mapper::convertToResource).collect(Collectors.toList());
		return new PageImpl<>(resources, pageable, resources.size());
	}

	@PostMapping("/{countryId}/languages/{languageId}")
	public CountryResource assignCountryLanguage(@PathVariable(name = "countryId") Integer countryId,
									  @PathVariable(name = "languageId") Integer languageId) {
		return mapper.convertToResource(countryService.assignCountryLanguage(countryId, languageId));
	}

	@DeleteMapping("/{countryId}/languages/{languageId}")
	public CountryResource unassignCountryLanguage(@PathVariable(name = "countryId") Integer countryId,
										@PathVariable(name = "languageId") Integer languageId) {

		return mapper.convertToResource(countryService.unassignCountryLanguage(countryId, languageId));
	}
}

