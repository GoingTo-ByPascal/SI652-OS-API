package goingto.com.controller;

import goingto.com.model.business.Partner;
import goingto.com.resource.converter.PromoConverter;
import goingto.com.service.PartnerService;
import goingto.com.service.PromoService;
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
public class PartnerPromosController {

    @Autowired
    PartnerService partnerService;

    @Autowired
    PromoService promoService;

    @Autowired
    PromoConverter mapper;

    @ApiOperation("Return Reviews by User id")
    @GetMapping("/partners/{partnerId}/promos")
    public ResponseEntity<?> getAllPromosByPartnerId(@PathVariable(name = "partnerId") Integer partnerId){
        Partner existingPartner = partnerService.getPartnerById(partnerId);
        if(existingPartner==null)
            return ResponseEntity.notFound().build();
        var promos = promoService.getAllPromosByPartnerId(partnerId);
        var result = promos.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
