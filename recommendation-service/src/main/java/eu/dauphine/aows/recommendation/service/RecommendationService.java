package eu.dauphine.aows.recommendation.service;

import eu.dauphine.aows.recommendation.dto.RecommendationResponse;
import eu.dauphine.aows.recommendation.entity.Reconmmendation;
import eu.dauphine.aows.recommendation.repository.RecommendationRepository;
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

    private RecommendationResponse mapToRecommendationResponse(Reconmmendation recommendation) {
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
