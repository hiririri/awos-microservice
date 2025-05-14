package eu.dauphine.aows.aggregate.service;

import eu.dauphine.aows.aggregate.client.ProductServiceClient;
import eu.dauphine.aows.aggregate.client.RecommendationServiceClient;
import eu.dauphine.aows.aggregate.client.ReviewServiceClient;
import eu.dauphine.aows.aggregate.dto.AggregateDto;
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
        var reviews = reviewServiceClient.getReviewByProductId(productId);
        var recommendations = recommendationServiceClient.getRecommendationByProductId(productId);

        return AggregateDto.builder()
                           .product(product)
                           .reviews(reviews)
                           .recommendations(recommendations)
                           .build();
    }

}
