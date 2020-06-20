package goingto.com.controller;

import goingto.com.model.business.Estate;
import goingto.com.resource.business.EstateResource;
import goingto.com.resource.converter.EstateConverter;
import goingto.com.service.EstateService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstateController {

    @Autowired
    EstateService estateService;

    @Autowired
    EstateConverter mapper;

    @ApiOperation("Return all Estates")
    @GetMapping("/estates")
    public ResponseEntity<List<Estate>> getAllEstates() {
        List<Estate> estates = new ArrayList<>();
        estates = estateService.getAllEstates();
        return ResponseEntity.ok(estates);

    }

    @ApiOperation("Return Estate by id")
    @GetMapping("/estates/{id}")
    public EstateResource getEstateById(@PathVariable(name = "id") Integer estateId) {
        return mapper.convertToResource(estateService.getEstateById(estateId));
    }


}
