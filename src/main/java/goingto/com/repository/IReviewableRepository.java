package goingto.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import goingto.com.model.Reviewable;

public interface IReviewableRepository extends JpaRepository<Reviewable, Long> {

}
