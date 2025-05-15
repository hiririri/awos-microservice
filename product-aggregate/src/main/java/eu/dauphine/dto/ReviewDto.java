package eu.dauphine.dto;

public record ReviewDto(Long reviewId, Long productId, String author, String subject, String content) {
}
