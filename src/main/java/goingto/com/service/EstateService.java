package goingto.com.service;

import goingto.com.model.business.Estate;

import java.util.List;

public interface EstateService {

    List<Estate> getAllEstates();
    List<Estate> getAllEstatesByServiceId(Integer serviceId);
    Estate getEstateById(Integer estateId);
}
