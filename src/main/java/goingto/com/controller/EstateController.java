package goingto.com.controller;

import goingto.com.model.business.Estate;
import goingto.com.model.geographic.Currency;
import goingto.com.resource.business.EstateResource;
import goingto.com.resource.converter.EstateConverter;
import goingto.com.resource.geographic.CurrencyResource;
import goingto.com.service.EstateService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
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
