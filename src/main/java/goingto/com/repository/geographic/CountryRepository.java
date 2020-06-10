package goingto.com.repository.geographic;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
