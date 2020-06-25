package goingto.com.controller;

import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Locatable;
import goingto.com.resource.converter.CountryConverter;
import goingto.com.service.CountryService;
import goingto.com.service.LocatableService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocatableCountryController {
    @Autowired
    LocatableService locatableService;

    @Autowired
    CountryService countryService;

    @Autowired
    CountryConverter mapper;

    @ApiOperation("Return Countries by Locatable id")
    @GetMapping("/locatables/{locatableId}/countries")
    public ResponseEntity<Country> getAllCountriesByLocatableId(@PathVariable(name = "locatableId") Integer locatableId) {
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if (existingLocatable == null)
            return ResponseEntity.notFound().build();
        var country = countryService.getCountryByLocatableId(locatableId);
        //var result = countries.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(country);
    }
}
