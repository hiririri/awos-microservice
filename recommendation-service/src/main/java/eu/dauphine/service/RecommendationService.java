package eu.dauphine.service;

import eu.dauphine.dto.RecommendationResponse;
import eu.dauphine.entity.Recommendation;
import eu.dauphine.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public List<RecommendationResponse> getRecommendationByProductId(Long productId) {
        return recommendationRepository.findByProductId(productId).stream()
                                       .map(this::mapToRecommendationResponse)
                                       .toList();
    }

    private RecommendationResponse mapToRecommendationResponse(Recommendation recommendation) {
        return RecommendationResponse.builder()
                                     .recommendationId(recommendation.getId())
                                     .productId(recommendation.getProductId())
                                     .author(recommendation.getAuthor())
                                     .rate(recommendation.getRate())
                                     .content(recommendation.getContent())
                                     .build();
    }

    public static class RecommendationNotFoundException extends RuntimeException {
        public RecommendationNotFoundException(Long productId) {
            super("Recommendation not found for productId: " + productId);
        }
    }

}
