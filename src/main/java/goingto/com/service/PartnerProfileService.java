package goingto.com.service;

import goingto.com.model.business.PartnerProfile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PartnerProfileService {
    List<PartnerProfile> getAllPartnerProfiles();
    PartnerProfile getPartnerProfileByPartnerId(Integer partnerId);
    PartnerProfile getPartnerProfileById(Integer partnerProfileId);
    PartnerProfile createPartnerProfile(PartnerProfile partnerProfile);
    PartnerProfile updatePartnerProfile(Integer partnerProfileId, PartnerProfile partnerProfileDetails);
    ResponseEntity<?> deletePartnerProfile(Integer partnerProfileId);
}
