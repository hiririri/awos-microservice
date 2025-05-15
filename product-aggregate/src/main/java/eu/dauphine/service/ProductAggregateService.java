package eu.dauphine.service;

import eu.dauphine.client.ProductServiceClient;
import eu.dauphine.client.RecommendationServiceClient;
import eu.dauphine.client.ReviewServiceClient;
import eu.dauphine.dto.AggregateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductAggregateService {

    private final ProductServiceClient productServiceClient;

    private final ReviewServiceClient reviewServiceClient;

    private final RecommendationServiceClient recommendationServiceClient;

    public AggregateDto getProductById(Long productId) {
        var product = productServiceClient.getProductById(productId);
        var reviews = reviewServiceClient.getReviewsByProductId(productId);
        var recommendations = recommendationServiceClient.getRecommendationsByProductId(productId);

        return AggregateDto.builder()
                           .product(product)
                           .reviews(reviews)
                           .recommendations(recommendations)
                           .build();
    }

}
