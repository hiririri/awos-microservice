package eu.dauphine.client;

import eu.dauphine.dto.RecommendationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "recommendation-service",
             path = "/api/v1")
public interface RecommendationServiceClient {

    @GetMapping("/recommendations")
    List<RecommendationDto> getRecommendationByProductId(@RequestParam("productId") Long productId);

}
