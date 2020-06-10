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
    public List<Partner> ListPartners() {
        return partnerRepository.findAll();
    }

    @Override
    public Partner findById(int partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", partnerId));
    }

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public ResponseEntity<?> deletePartner(int partnerId) {
        return partnerRepository.findById(partnerId).map(partner -> {
            partnerRepository.delete(partner);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Review", "Id", partnerId));

    }
}
