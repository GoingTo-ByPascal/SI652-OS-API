package goingto.com.repository.business;

import goingto.com.model.business.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends JpaRepository<Estate,Integer> {
}
