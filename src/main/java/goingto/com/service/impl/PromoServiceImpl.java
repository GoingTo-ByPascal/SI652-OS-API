package goingto.com.service.impl;

import goingto.com.exception.ResourceNotFoundException;
import goingto.com.model.business.Promo;
import goingto.com.model.geographic.Language;
import goingto.com.repository.business.PromoRepository;
import goingto.com.repository.geographic.LocatableRepository;
import goingto.com.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoRepository promoRepository;
    @Autowired
    LocatableRepository locatableRepository;

    @Override
    public List<Promo> getAllPromos() {
        return promoRepository.findAll();
    }

    @Override
    public List<Promo> getAllPromosByPartnerId(Integer partnerId) {
        return promoRepository.getByPartnerId(partnerId);
    }

    @Override
    public List<Promo> getAllPromosByLocatableId(Integer locatableId) {
        return locatableRepository.findById(locatableId).map(locatable -> {
            List<Promo> promos = locatable.getPromos();
            return promos;
        }).orElseThrow(() -> new ResourceNotFoundException("Locatable", "Id",locatableId));
    }

    @Override
    public Promo getPromoById(Integer promoId) {
        return promoRepository.findById(promoId)
                .orElseThrow(() -> new ResourceNotFoundException("Promo", "Id", promoId));
    }

    @Override
    public Promo createPromo(Promo promo) {
        return promoRepository.save(promo);
    }

    @Override
    public Promo updatePromo(Integer promoId, Promo promoDetails) {
        return promoRepository.findById(promoId).map(promo -> {
            promo.setText(promoDetails.getText());
            promo.setDiscount(promoDetails.getDiscount());
            return promoRepository.save(promo);
        }).orElseThrow(() -> new ResourceNotFoundException("Promo", "Id", promoId));
    }

    @Override
    public ResponseEntity<?> deletePromo(Integer promoId) {
        return promoRepository.findById(promoId).map(promo -> {
            promoRepository.delete(promo);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Promo", "Id", promoId));
    }

}
