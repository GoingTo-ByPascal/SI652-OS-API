package goingto.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}