package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.EstateService;
import goingto.com.repository.business.EstateServiceRepository;
import goingto.com.service.EstateServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateServiceServiceImpl implements EstateServiceService {

    @Autowired
    EstateServiceRepository estateServiceRepository;

    @Override
    public List<EstateService> getAll() {
        return estateServiceRepository.findAll();
    }

    @Override
    public EstateService getById(Integer id) {
        return estateServiceRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Estate Service","ID",id));
    }

    @Override
    public EstateService createEstateService(EstateService estateService) {
        return estateServiceRepository.save(estateService);
    }

    @Override
    public EstateService getByEstateIdAndServiceId(Integer estateId, Integer serviceId) {
        return estateServiceRepository.findByEstateIdAndServiceId(estateId,serviceId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Estate Service not found with Estate ID " + estateId +
                                " and Service ID " + serviceId));
    }

    @Override
    public void deleteEstateService(EstateService estateService) {
        estateServiceRepository.delete(estateService);
    }
}
