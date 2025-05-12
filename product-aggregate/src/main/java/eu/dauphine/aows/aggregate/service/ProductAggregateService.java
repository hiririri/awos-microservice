package eu.dauphine.aows.aggregate.service;

import eu.dauphine.aows.aggregate.client.ProductServiceClient;
import eu.dauphine.aows.aggregate.client.ReviewServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ProductAggregateService {

    private final ProductServiceClient productServiceClient;

    private final ReviewServiceClient reviewServiceClient;

    public Map<String, Long> getProductById(Long productId) {
        var product = productServiceClient.getProductById(productId);
        var review = reviewServiceClient.getReviewByProductId(productId);

        return Map.of("productId", product.productId(),
                      "reviewId", review.reviewId());
    }

}
