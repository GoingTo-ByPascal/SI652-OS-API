package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import goingto.com.model.Locatable;
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

	@GetMapping
	public ResponseEntity<List<Country>> listCountries(){
		List<Country> countries = new ArrayList<>();

		countries = countryService.getAllCountries();

		if(countries.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(countries);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Country>getById(@PathVariable Integer id)
	{
		Country country = countryService.getCountryById(id);
		if(country ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(country));
	}

}

