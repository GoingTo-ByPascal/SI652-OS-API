package goingto.com.controller.sprint5;

import goingto.com.model.business.Estate;
import goingto.com.model.interaction.Tip;
import goingto.com.resource.business.SaveEstateResource;
import goingto.com.resource.converter.EstateConverter;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.service.EstateService;
import goingto.com.service.LocatableService;
import goingto.com.service.PartnerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PartnerLocatableEstateController {

    @Autowired
    PartnerService partnerService;

    @Autowired
    LocatableService locatableService;

    @Autowired
    EstateService estateService;

    @Autowired
    EstateConverter mapper;

    @ApiOperation("Create Estate by Partner id and Locatable id")
    @PostMapping("/partners/{partnerId}/locatables/{locatableId}/estates")
    public ResponseEntity<?> createEstate(@PathVariable Integer partnerId, @PathVariable Integer locatableId, @Valid @RequestBody SaveEstateResource resource) {
        var existingPartner = partnerService.getPartnerById(partnerId);
        var existingLocatable = locatableService.getLocatable(locatableId);
        if (existingLocatable == null)
            return ResponseEntity.notFound().build();
        if (existingPartner == null)
            return ResponseEntity.notFound().build();
        var estate = mapper.convertToEntity(resource);
        estate.setLocatable(existingLocatable);
        estate.setPartner(existingPartner);
        var result = estateService.createEstate(estate);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

   /* @ApiOperation("Update Tips by User id and Locatable id")
    @PutMapping("/users/{userId}/locatables/{locatableId}/tips")*/

    @ApiOperation("Update Estates by Partner id and Locatable id")
    @GetMapping("/partners/{partnerId}/locatables/{locatableId}/estates")
    public List<Estate> getEstatesByUserIdAndLocatableId(@PathVariable(name = "partnerId") Integer partnerId, @PathVariable(name = "locatableId") Integer locatableId){
        return estateService.getAllEstatesByPartnerIdAndLocatableId(partnerId, locatableId);
    }

    @ApiOperation("Delete Estates by Partner id and Locatable id")
    @DeleteMapping("/partners/{partnerId}/locatables/{locatableId}/estates")
    public void deleteEstatesByUserIdAndLocatableId (@PathVariable(name = "partnerId") Integer partnerId, @PathVariable(name = "locatableId") Integer locatableId)
    {
        List<Estate> estates = estateService.getAllEstatesByPartnerIdAndLocatableId(partnerId,locatableId);
        var currentEstate = new Estate();
        for (int i = 0 ; i < estates.size(); i++){

            currentEstate = estates.get(i);
            estateService.deleteEstate(currentEstate.getId());
        }
    }
}
