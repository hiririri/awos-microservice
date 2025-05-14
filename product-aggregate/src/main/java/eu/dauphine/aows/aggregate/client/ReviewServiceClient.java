package eu.dauphine.aows.aggregate.client;

import eu.dauphine.aows.aggregate.dto.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service",
             path = "/api/v1")
public interface ReviewServiceClient {

    @GetMapping("/reviews/{productId}")
    List<ReviewDto> getReviewByProductId(@PathVariable("productId") Long productId);

}
