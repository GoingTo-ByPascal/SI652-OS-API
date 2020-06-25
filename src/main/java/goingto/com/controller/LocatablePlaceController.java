package goingto.com.controller;

import goingto.com.model.geographic.Locatable;
import goingto.com.resource.converter.PlaceConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.PlaceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocatablePlaceController {

    @Autowired
    LocatableService locatableService;

    @Autowired
    PlaceService placeService;

    @Autowired
    PlaceConverter mapper;

    @ApiOperation("Return Places by Locatable id")
    @GetMapping("/locatables/{locatableId}/places")
    public ResponseEntity<?> getAllPlacesByLocatableId(@PathVariable(name = "locatableId") Integer locatableId) {
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if (existingLocatable == null)
            return ResponseEntity.notFound().build();
        var places = placeService.getAllPlacesByLocatableId(locatableId);
        var result = places.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
