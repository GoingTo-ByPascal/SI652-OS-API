package goingto.com.service;


import goingto.com.model.business.Partner;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PartnerService {
    List<Partner> ListPartners();
    Partner findById(int id);
    Partner save(Partner partner);
    ResponseEntity<?> deletePartner (int id);
}
