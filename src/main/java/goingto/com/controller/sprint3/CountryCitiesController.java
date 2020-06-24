package goingto.com.controller.sprint3;

import goingto.com.resource.converter.CityConverter;
import goingto.com.service.CityService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
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
