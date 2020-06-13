package goingto.com.repository.geographic;

import java.util.List;

import goingto.com.model.geographic.Locatable;
import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.City;
import goingto.com.model.geographic.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
 List<City> findByCountryId(Integer countryId);
 List<City> findAllByLocatableId(Integer locatableId);
}
