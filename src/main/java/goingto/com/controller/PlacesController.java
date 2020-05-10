package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import goingto.com.model.Place;
import goingto.com.service.IPlaceService;

public class PlacesController {

	@Autowired
	private IPlaceService placeService;
	
	
	@GetMapping
	public ResponseEntity<List<Place>> listLocatables(){
		List<Place> places = new ArrayList<>();
		
		places = placeService.listAllPlaces();
			if(places.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
	
		return ResponseEntity.ok(places);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Place>getById(@PathVariable Long id)
	{
		Place places = placeService.getPlace(id);
		if(places ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(places));
	}
	
	@PostMapping
	public ResponseEntity<Place> newPlace(@RequestBody Place place)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(placeService.save((place)));
	}
	
	@PutMapping
	public ResponseEntity<Place> updatePlace(@RequestBody Place place,@PathVariable Long id)
	{
		return  ResponseEntity.status(HttpStatus.OK).body(placeService.edit(place, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Place> deletePlace(@PathVariable Long id)
	{
		placeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
