package goingto.com.controller.sprint3;

import goingto.com.resource.converter.PlaceConverter;
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
@ApiOperation("/Controller for CityPlaces")
@RequestMapping("/api")
public class CityPlacesController {

    @Autowired
    PlaceService placeService;

    @Autowired
    PlaceConverter mapper;

    @ApiOperation("Return Places by City id")
    @GetMapping("/cities/{cityId}/places")
    public ResponseEntity<?> getAllPlacesByCityId(@PathVariable(name = "cityId") Integer cityId) {
        var places = placeService.getAllPlacesByCityId(cityId);
        var result = places.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
