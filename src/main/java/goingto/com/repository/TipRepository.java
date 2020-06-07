package goingto.com.repository;

import com.sun.jdi.event.LocatableEvent;
import goingto.com.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipRepository extends JpaRepository<Tip, Integer> {
    List<Tip> getByUserId(User user);
    List<Tip> getByLocatableId(Locatable locatable);
}
