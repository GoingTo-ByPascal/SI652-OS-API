package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import goingto.com.model.Place;
import goingto.com.service.PlaceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	
	
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
	public ResponseEntity<Place>getById(@PathVariable Integer id)
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
	public ResponseEntity<Place> updatePlace(@RequestBody Place place,@PathVariable Integer id)
	{
		return  ResponseEntity.status(HttpStatus.OK).body(placeService.edit(place, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Place> deletePlace(@PathVariable Integer id)
	{
		placeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
