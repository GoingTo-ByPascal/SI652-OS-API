package goingto.com.repository.business;

import goingto.com.model.business.PlanBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanBenefitRepository extends JpaRepository<PlanBenefit,Integer> {
}
