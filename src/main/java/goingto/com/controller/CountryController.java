package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiOperation;
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

	@ApiOperation("Return all Countries")
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getAllCountries(){
		List<Country> countries = new ArrayList<>();
		countries = countryService.getAllCountries();
		return ResponseEntity.ok(countries);
	}

	@ApiOperation("Return Country by id")
	@GetMapping("/countries/{id}")
	public ResponseEntity<Country>getCountryById(@PathVariable Integer id)
	{
		Country country = countryService.getCountryById(id);
		if(country ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(country));
	}

}

