package eu.dauphine.client;

import eu.dauphine.dto.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "review-service",
             path = "/api/v1")
public interface ReviewServiceClient {

    @GetMapping("/reviews")
    List<ReviewDto> getReviewByProductId(@RequestParam("productId") Long productId);

}
