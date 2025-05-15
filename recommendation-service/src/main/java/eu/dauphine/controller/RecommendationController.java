package eu.dauphine.controller;


import eu.dauphine.dto.RecommendationResponse;
import eu.dauphine.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/recommendations")
    public List<RecommendationResponse> getRecommendationByProductId(@RequestParam("productId") Long productId) {
        return recommendationService.getRecommendationByProductId(productId);
    }

}
