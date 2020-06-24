package goingto.com.controller.sprint5;

import goingto.com.model.business.Partner;
import goingto.com.model.business.Promo;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.business.SavePromoResource;
import goingto.com.resource.converter.PromoConverter;
import goingto.com.service.PartnerService;
import goingto.com.service.PromoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @ApiOperation("Return Promos by Partner id")
    @GetMapping("/partners/{partnerId}/promos")
    public ResponseEntity<List<Promo>> getAllPromosByPartnerId(@PathVariable(name = "partnerId") Integer partnerId){
        Partner existingPartner = partnerService.getPartnerById(partnerId);
        if(existingPartner==null)
            return ResponseEntity.notFound().build();
        var promos = promoService.getAllPromosByPartnerId(partnerId);
        //var result = promos.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(promos);
    }

    @ApiOperation("Create Promos by Partner ID")
    @PostMapping("/partners/{partnerId}/promos")
    public Promo createPartnerPromo(@PathVariable Integer partnerId, @Valid @RequestBody SavePromoResource resource) {
        var existingPartner = partnerService.getPartnerById(partnerId);
        var promo = mapper.convertToEntity(resource);
        promo.setPartner(existingPartner);
        var result = promoService.createPromo(promo);
        return result;
    }

    //FALTA
    @ApiOperation("Delete existing Promo by Partner id")
    @DeleteMapping("/partners/{partnerId}/promos")
    public List<Promo> deletePartnerPromo(@PathVariable(name = "partnerId") Integer partnerId) {
        List<Promo> promos = promoService.getAllPromosByPartnerId(partnerId);
        var currentPromo = new Promo();
        for (int i = 0; i < promos.size(); i++) {

            currentPromo = promos.get(i);
            promoService.deletePromo(currentPromo.getId());
        }
        return promos;
    }
}
