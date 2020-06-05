package goingto.com.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sun.jdi.Locatable;
import goingto.com.service.LocatableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locatables")
public class LocatableController {

	@Autowired
	private LocatableService locatableService;
	
	@GetMapping
	public ResponseEntity<List<Locatable>> listLocatables(){
		List<Locatable> locatables = new ArrayList<>();
		
			locatables = locatableService.listAllLocatable();
			if(locatables.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
	
		return ResponseEntity.ok(locatables);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Locatable>getById(@PathVariable Integer id)
	{
		Locatable locatable = locatableService.getLocatable(id);
		if(locatable ==null)
			return ResponseEntity.notFound().build();
		else
			return (ResponseEntity.ok(locatable));
	}
}
