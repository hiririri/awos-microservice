package eu.dauphine.aows.aggregate.client;

import eu.dauphine.aows.aggregate.dto.RecommendationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "recommendation-service",
             path = "/api/v1/recommendations")
public interface RecommendationServiceClient {

    @GetMapping("/{productId}")
    List<RecommendationDto> getRecommendationByProductId(@PathVariable("productId") Long productId);

}
