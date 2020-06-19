package goingto.com.repository.business;

import goingto.com.model.business.Estate;
import goingto.com.model.interaction.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateRepository extends JpaRepository<Estate,Integer> {
    List<Estate> findByPartnerIdAndLocatableId(Integer partnerId, Integer LocatableId);
}
