package goingto.com.service;

import goingto.com.model.business.Estate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstateService {

    List<Estate> getAllEstates();
    List<Estate> getAllEstatesByServiceId(Integer serviceId);
    List<Estate> getAllEstatesByPartnerIdAndLocatableId (Integer partnerId, Integer locatableId);
    Estate getEstateById(Integer estateId);
    Estate createEstate(Estate estate);
    ResponseEntity<?> deleteEstate(Integer estateId);
}
