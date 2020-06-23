package goingto.com.controller.sprint3;

import goingto.com.resource.converter.PlaceConverter;
import goingto.com.service.CountryService;
import goingto.com.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CountryPlacesController {

    @Autowired
    CountryService countryService;

    @Autowired
    PlaceService placeService;

    @Autowired
    PlaceConverter mapper;

    @GetMapping("countries/{countryId}/places")
    public ResponseEntity<?> getAllPlacesByCountryId(@PathVariable(name = "countryId") Integer countryId) {
        var existingCountry = countryService.getCountryById(countryId);
        var places = placeService.getAllPlacesByCityId(existingCountry.getC().getId());
        var result = reviews.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);

    }

}
