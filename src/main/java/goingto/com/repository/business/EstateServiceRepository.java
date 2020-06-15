package goingto.com.repository.business;

import goingto.com.model.business.EstateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstateServiceRepository extends JpaRepository<EstateService , Integer> {
    Optional<EstateService> findByEstateIdAndServiceId(Integer partnerId, Integer serviceId);
}
