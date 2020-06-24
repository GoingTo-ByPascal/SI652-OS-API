package goingto.com.controller.sprint5;

import goingto.com.model.business.PartnerProfile;
import goingto.com.resource.business.SavePartnerProfileResource;
import goingto.com.resource.converter.PartnerProfileConverter;
import goingto.com.service.PartnerProfileService;
import goingto.com.service.PartnerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PartnerPartnerProfileController {

    @Autowired
    PartnerService partnerService;

    @Autowired
    PartnerProfileService partnerProfileService;

    @Autowired
    PartnerProfileConverter mapper;

    @ApiOperation("Return PartnerProfile by Partner id")
    @GetMapping("/partners/{partnerId}/partner_profiles")
    public ResponseEntity<PartnerProfile> getPartnerProfileByPartnerId(@PathVariable(name = "partnerId") Integer partnerId) {
        var partnerProfiles = partnerProfileService.getPartnerProfileByPartnerId(partnerId);
        //var result = partnerProfiles;
        return ResponseEntity.ok(partnerProfiles);
    }

    @ApiOperation("Create PartnerProfile by Partner id")
    @PostMapping("/partners/{partnerId}/partner_profiles")
    public PartnerProfile createPartnerProfileByPartnerId(@PathVariable Integer partnerId, @Valid @RequestBody SavePartnerProfileResource resource) {
        var existingPartner = partnerService.getPartnerById(partnerId);
        var partnerProfile = mapper.convertToEntity(resource);
        partnerProfile.setPartner(existingPartner);
        var result = partnerProfileService.createPartnerProfile(partnerProfile);
        return result;
    }

    @ApiOperation("Update Partner Profile by Partner id")
    @PutMapping("/partners/{partnerId}/partner_profiles")
    public PartnerProfile updatePartnerProfile(@PathVariable(name = "partnerId") Integer partnerId, @Valid @RequestBody SavePartnerProfileResource resource) {
        var PartnerProfile = partnerProfileService.getPartnerProfileByPartnerId(partnerId);
        var result = partnerProfileService.updatePartnerProfile(PartnerProfile.getId(), mapper.convertToEntity(resource));
        return result;
    }

    @ApiOperation("Delete existing Partner Profile by Partner id")
    @DeleteMapping("/partners/{partnerId}/partner_profiles")
    public ResponseEntity<?> deletePartnerProfileByPartnerId(@PathVariable(name = "partnerId") Integer partnerId) {
        var partnerProfile = partnerProfileService.getPartnerProfileByPartnerId(partnerId);
        return partnerProfileService.deletePartnerProfile(partnerProfile.getId());
    }


}
