package goingto.com.repository.geographic;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.geographic.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findAllByLocatableId(Integer locatableId);
}
