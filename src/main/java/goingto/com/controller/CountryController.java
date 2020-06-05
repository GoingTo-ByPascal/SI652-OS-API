package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

