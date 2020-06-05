package goingto.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.City;
import goingto.com.model.Country;

public interface ICityRepository extends JpaRepository<City, Integer> {
 List<City> findByCountryId(Country country);
}
