package goingto.com.service;

import goingto.com.model.business.EstateService;

import java.util.List;

public interface EstateServiceService {
    List<EstateService> getAll();
    EstateService getById(Integer id);
    EstateService createEstateService(EstateService estateService);
    EstateService getByEstateIdAndServiceId(Integer estateId, Integer serviceId);
    void deleteEstateService(EstateService estateService);
}
