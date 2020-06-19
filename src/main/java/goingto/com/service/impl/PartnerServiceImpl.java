package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.Partner;
import goingto.com.repository.business.PartnerRepository;
import goingto.com.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    @Override
    public Partner getPartnerById(Integer partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Partner", "Id", partnerId));
    }

    @Override
    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public ResponseEntity<?> deletePartner(Integer partnerId) {
        return partnerRepository.findById(partnerId).map(partner -> {
            partnerRepository.delete(partner);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Partner", "Id", partnerId));

    }
}
