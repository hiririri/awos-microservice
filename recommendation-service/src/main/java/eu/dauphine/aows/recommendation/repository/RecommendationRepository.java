package eu.dauphine.aows.recommendation.repository;

import eu.dauphine.aows.recommendation.entity.Reconmmendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Reconmmendation, Long> {

    List<Reconmmendation> findByProductId(Long productId);

}
