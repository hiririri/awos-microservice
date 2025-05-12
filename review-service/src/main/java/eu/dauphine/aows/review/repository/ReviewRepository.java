package eu.dauphine.aows.review.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.dauphine.aows.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByProductId(Long productId);

}
