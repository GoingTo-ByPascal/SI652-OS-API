package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.Estate;
import goingto.com.repository.business.EstateRepository;
import goingto.com.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Override
    public List<Estate> getAllEstates() {
        return estateRepository.findAll();
    }

    @Override
    public List<Estate> getAllEstatesByServiceId(Integer serviceId) {
        return estateRepository.findAll();
    }

    @Override
    public List<Estate> getAllEstatesByPartnerIdAndLocatableId(Integer partnerId, Integer locatableId) {
        return estateRepository.findByPartnerIdAndLocatableId(partnerId,locatableId);
    }

    @Override
    public Estate getEstateById(Integer estateId) {
        return estateRepository.findById(estateId)
                .orElseThrow(() ->new ResourceNotFoundException("Estate", "Id", estateId));

    }

    @Override
    public Estate createEstate(Estate estate) {
        return estateRepository.save(estate);
    }

    @Override
    public ResponseEntity<?> deleteEstate(Integer estateId) {
        return estateRepository.findById(estateId).map(estate -> {
            estateRepository.delete(estate);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Estate", "Id", estateId));
    }
}
