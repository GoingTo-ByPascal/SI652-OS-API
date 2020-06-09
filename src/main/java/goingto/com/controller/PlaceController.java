package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import goingto.com.model.geographic.Place;
import goingto.com.service.PlaceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@ApiOperation("Return all Places")
	@GetMapping("/places")
	public ResponseEntity<List<Place>> listPlaces(){
		List<Place> places = new ArrayList<>();
		
		places = placeService.listAllPlaces();
			if(places.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
	
		return ResponseEntity.ok(places);
	}

	@ApiOperation("Return Place by id")
	@GetMapping("/places/{id}")
	public ResponseEntity<Place>getById(@PathVariable Integer id)
	{
		Place places = placeService.getPlace(id);
		if(places ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(places));
	}

	@ApiOperation("Create new Place")
	@PostMapping("/places")
	public ResponseEntity<Place> newPlace(@RequestBody Place place)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(placeService.save((place)));
	}

	@ApiOperation("Update existing Place by id")
	@PutMapping("/places/{id}")
	public ResponseEntity<Place> updatePlace(@RequestBody Place place,@PathVariable Integer id)
	{
		return  ResponseEntity.status(HttpStatus.OK).body(placeService.edit(place, id));
	}

	@ApiOperation("Delete existing Place by id")
	@DeleteMapping("/places/{id}")
	public ResponseEntity<Place> deletePlace(@PathVariable Integer id)
	{
		placeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
