package goingto.com.service;

import goingto.com.model.business.Partner;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PartnerService {
    List<Partner> getAllPartners();
    Partner getPartnerById(Integer partnerId);
    Partner createPartner(Partner partner);
    ResponseEntity<?> deletePartner (Integer partnerId);
}
