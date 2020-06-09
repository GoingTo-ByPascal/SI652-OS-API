package goingto.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
 List<City> findByCountryId(Country country);
}
