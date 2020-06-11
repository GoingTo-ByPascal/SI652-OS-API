package goingto.com.service;


import goingto.com.model.business.Promo;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PromoService {
    List<Promo> getAllPromos();
    List<Promo> getAllPromosByPartnerId(Integer partnerId);
    List<Promo> getAllPromosByLocatableId(Integer locatableId);
    Promo getPromoById(Integer promoId);
    Promo createPromo(Promo promo);
    Promo updatePromo(Integer PromoId, Promo promoDetails);
    ResponseEntity<?> deletePromo(Integer promoId);
}
