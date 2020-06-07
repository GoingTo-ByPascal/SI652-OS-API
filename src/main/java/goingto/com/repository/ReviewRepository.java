package goingto.com.repository;

import com.sun.jdi.event.LocatableEvent;
import goingto.com.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> getByUserId(User user);
    List<Review> getByLocatableId(Locatable locatable);
}
