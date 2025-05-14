package eu.dauphine.aows.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponse {

    private Long recommendationId;

    private Long productId;

    private String author;

    private Double rate;

    private String content;

}