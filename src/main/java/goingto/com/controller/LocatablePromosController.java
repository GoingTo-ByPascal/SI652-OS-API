package goingto.com.controller;

import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Locatable;
import goingto.com.resource.converter.PromoConverter;
import goingto.com.service.LocatableService;
import goingto.com.service.PromoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LocatablePromosController {

    @Autowired
    LocatableService locatableService;

    @Autowired
    PromoService promoService;

    @Autowired
    PromoConverter mapper;

    @ApiOperation("Return Promos by Locatable id")
    @GetMapping("/locatables/{locatableId}/promos")
    public ResponseEntity<?> getAllPromosByLocatableId(@PathVariable(name = "locatableId") Integer locatableId) {
        Locatable existingLocatable = locatableService.getLocatable(locatableId);
        if(existingLocatable==null)
            return ResponseEntity.notFound().build();
        var promos = promoService.getAllPromosByLocatableId(locatableId);
        var result = promos.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
