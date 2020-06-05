package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import goingto.com.model.Country;
import goingto.com.service.ICountryService;

public class CountriesController {

	@Autowired
	private ICountryService countryService;
	
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
}

