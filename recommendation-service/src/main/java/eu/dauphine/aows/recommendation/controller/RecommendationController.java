package eu.dauphine.aows.recommendation.controller;

import eu.dauphine.aows.recommendation.dto.RecommendationResponse;
import eu.dauphine.aows.recommendation.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendations")
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{productId}")
    public List<RecommendationResponse> getRecommendationByProductId(@PathVariable("productId") Long productId) {
        return recommendationService.getRecommendationByProductId(productId);
    }

}
