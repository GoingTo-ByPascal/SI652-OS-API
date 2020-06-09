package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import goingto.com.model.geographic.Country;
import goingto.com.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> listCountries(){
		List<Country> countries = new ArrayList<>();

		countries = countryService.getAllCountries();

		if(countries.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(countries);
	}

	@GetMapping("/countries/{id}")
	public ResponseEntity<Country>getById(@PathVariable Integer id)
	{
		Country country = countryService.getCountryById(id);
		if(country ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(country));
	}

}

