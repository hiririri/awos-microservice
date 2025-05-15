package eu.dauphine.client;

import eu.dauphine.configuration.RecommendationServiceClientFallbackFactory;
import eu.dauphine.dto.RecommendationDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "recommendation-service",
             path = "/api/v1",
             fallbackFactory = RecommendationServiceClientFallbackFactory.class)
public interface RecommendationServiceClient {

    @GetMapping("/recommendations")
    @Retry(name = "recommendation-service")
    List<RecommendationDto> getRecommendationsByProductId(@RequestParam("productId") Long productId);

}
