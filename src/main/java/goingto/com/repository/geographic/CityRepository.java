package goingto.com.repository.geographic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
 List<City> findByCountryId(Integer countryId);
 City findByLocatableId(Integer locatableId);
}
