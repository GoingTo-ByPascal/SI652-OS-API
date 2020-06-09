package goingto.com.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Country;
import goingto.com.service.CityService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<City>> listCity(@RequestParam(name="CountryId",required = false)Integer countryId){
		List<City> cities = new ArrayList<>();
		if(countryId == null)
		{
			cities = cityService.listAllCities();
			if(cities.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		else {
			cities=cityService.findByCountry(Country.builder().id(countryId).build());
		}
		return ResponseEntity.ok(cities);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<City>getById(@PathVariable Integer id)
	{
		City city = cityService.getCity(id);
		if(city ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(city));
	}
}
