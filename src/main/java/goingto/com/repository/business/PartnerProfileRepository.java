package goingto.com.repository.business;

import goingto.com.model.business.PartnerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerProfileRepository extends JpaRepository<PartnerProfile,Integer> {
    PartnerProfile findByPartnerId(Integer partnerId);
}
