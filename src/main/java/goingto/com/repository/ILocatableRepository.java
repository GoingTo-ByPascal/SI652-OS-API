package goingto.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.jdi.Locatable;

public interface ILocatableRepository extends JpaRepository<Locatable, Long> {

}
