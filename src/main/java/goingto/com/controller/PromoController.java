package goingto.com.controller;

import goingto.com.model.business.Promo;
import goingto.com.resource.business.PromoResource;
import goingto.com.resource.business.SavePromoResource;
import goingto.com.resource.converter.PromoConverter;
import goingto.com.service.PromoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PromoController {

    @Autowired
    PromoService promoService;

    @Autowired
    PromoConverter mapper;

    @ApiOperation("Return all Promos")
    @GetMapping("/promos")
    public ResponseEntity<List<Promo>> getAllPromos() {
        List<Promo> promos = new ArrayList<>();
        promos = promoService.getAllPromos();
        return ResponseEntity.ok(promos);
    }

    @ApiOperation("Return Promo by id")
    @GetMapping("/promos/{id}")
    public PromoResource getPromoById(@PathVariable(name = "id") Integer promoId) {
        return mapper.convertToResource(promoService.getPromoById(promoId));
    }

    @ApiOperation("Create new Promo")
    @PostMapping("/promos")
    public PromoResource createPromo(@Valid @RequestBody SavePromoResource resource) {
        return mapper.convertToResource(promoService.createPromo(mapper.convertToEntity(resource)));
    }

    @ApiOperation("Update existing Promo by id")
    @PutMapping("/promos/{id}")
    public PromoResource updatePromo(@PathVariable(name = "id") Integer promoId, @Valid @RequestBody SavePromoResource resource) {
        return mapper.convertToResource(promoService.updatePromo(promoId, mapper.convertToEntity(resource)));
    }

    @ApiOperation("Delete existing Promo by id")
    @DeleteMapping("/Promos/{id}")
    public ResponseEntity<?> deletePromo(@PathVariable(name = "id") Integer promoId) {
        return promoService.deletePromo(promoId);
    }
}
