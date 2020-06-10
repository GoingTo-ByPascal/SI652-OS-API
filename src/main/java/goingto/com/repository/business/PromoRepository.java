package goingto.com.repository.business;

import goingto.com.model.business.Partner;
import goingto.com.model.business.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoRepository extends JpaRepository<Promo,Integer> {
    List<Promo> getByPartnerId(Integer partnerId);
}
