package goingto.com.repository.account;

import goingto.com.model.account.PlanUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanUserRepository extends JpaRepository<PlanUser,Integer> {
}
