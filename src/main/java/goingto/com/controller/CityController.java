package goingto.com.controller;


import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goingto.com.model.geographic.City;
import goingto.com.service.CityService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@ApiOperation("/Controller for Cities")
@RequestMapping("/api")
public class CityController {

	@Autowired
	private CityService cityService;

	@ApiOperation("Return all Cities")
	@GetMapping("/cities")
	public ResponseEntity<List<City>> getAllCities(){
		List<City> cities = new ArrayList<>();
		cities = cityService.listAllCities();
		return ResponseEntity.ok(cities);
	}

	@ApiOperation("Return City by Id")
	@GetMapping("/cities/{id}")
	public ResponseEntity<City>getCityById(@PathVariable Integer id)
	{
		City city = cityService.getCity(id);
		if(city ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(city));
	}
}
