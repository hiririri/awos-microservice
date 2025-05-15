package eu.dauphine.dto;

public record RecommendationDto(Long recommendationId, Long productId, String author, Double rate, String content) {
}
