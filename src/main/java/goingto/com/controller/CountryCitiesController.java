package goingto.com.controller;

import goingto.com.resource.converter.CityConverter;
import goingto.com.service.CityService;
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
@ApiOperation("/Controller for CountryCities")
@RequestMapping("/api")
public class CountryCitiesController {

    @Autowired
    CityService cityService;

    @Autowired
    CityConverter mapper;

    @ApiOperation("Return Cities by Country id")
    @GetMapping("/countries/{countryId}/cities")
    public ResponseEntity<?> getAllCitiesByCountryId(@PathVariable(name = "countryId") Integer countryId) {
        var cities = cityService.getAllCitiesByCountryId(countryId);
        var result = cities.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
