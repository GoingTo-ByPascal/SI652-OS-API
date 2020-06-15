package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.PartnerProfile;
import goingto.com.repository.business.PartnerProfileRepository;
import goingto.com.service.PartnerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PartnerProfileServiceImpl implements PartnerProfileService {

    @Autowired
    PartnerProfileRepository partnerProfileRepository;


    @Override
    public List<PartnerProfile> getAllPartnerProfiles() {
        return partnerProfileRepository.findAll();
    }

    @Override
    public PartnerProfile getPartnerProfileByPartnerId(Integer partnerId) {
        return partnerProfileRepository.findByPartnerId(partnerId);
    }

    @Override
    public PartnerProfile getPartnerProfileById(Integer partnerProfileId) {
        return partnerProfileRepository.findById(partnerProfileId)
                .orElseThrow(()->new ResourceNotFoundException("Partner Profile"," ID ",partnerProfileId));
    }

    @Override
    public PartnerProfile createPartnerProfile(PartnerProfile partnerProfile) {
        return partnerProfileRepository.save(partnerProfile);
    }

    @Override
    public PartnerProfile updatePartnerProfile(Integer partnerProfileId, PartnerProfile partnerProfileDetails) {
        return partnerProfileRepository.findById(partnerProfileId).map(partnerProfile -> {
            partnerProfile.setName(partnerProfileDetails.getName());
            partnerProfile.setTelephone(partnerProfileDetails.getTelephone());
            partnerProfile.setEmail(partnerProfileDetails.getEmail());
            partnerProfile.setAddress(partnerProfileDetails.getAddress());
            return partnerProfileRepository.save(partnerProfile);
        }).orElseThrow(() -> new ResourceNotFoundException("Partner Profile", "Id", partnerProfileId));
    }

    @Override
    public ResponseEntity<?> deletePartnerProfile(Integer partnerProfileId) {
        return partnerProfileRepository.findById(partnerProfileId).map(partnerProfile -> {
            partnerProfileRepository.delete(partnerProfile);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Partner Profile", "Id", partnerProfileId));
    }
}
