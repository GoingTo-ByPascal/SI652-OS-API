package goingto.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.Country;

public interface ICountryRepository extends JpaRepository<Country, Long> {

}
