package goingto.com.service;

import goingto.com.model.account.Favourite;
import goingto.com.model.business.EstateService;
import goingto.com.model.geographic.Locatable;

import java.util.List;

public interface EstateServiceService {
    EstateService createEstateService(EstateService estateService);
    EstateService getByEstateIdAndServiceId(Integer estateId, Integer serviceId);
    void deleteEstateService(EstateService estateService);
}
