package eu.dauphine.client;

import eu.dauphine.configuration.ReviewServiceClientFallbackFactory;
import eu.dauphine.dto.ReviewDto;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "review-service",
             path = "/api/v1",
             fallbackFactory = ReviewServiceClientFallbackFactory.class)
public interface ReviewServiceClient {

    @GetMapping("/reviews")
    @Retry(name = "review-service")
    List<ReviewDto> getReviewsByProductId(@RequestParam("productId") Long productId);

}
