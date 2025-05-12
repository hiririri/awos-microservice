package eu.dauphine.aows.review.service;

import org.springframework.stereotype.Service;

import eu.dauphine.aows.review.dto.ReviewResponse;
import eu.dauphine.aows.review.entity.Review;
import eu.dauphine.aows.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewResponse getReviewByProductId(Long productId) {
        return reviewRepository.findByProductId(productId)
                .map(this::mapToReviewResponse)
                .orElseThrow(() -> new ReviewNotFoundException(productId));
    }

    private ReviewResponse mapToReviewResponse(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getId())
                .productId(review.getProductId())
                .author(review.getAuthor())
                .subject(review.getSubject())
                .content(review.getContent())
                .build();
    }

    private static class ReviewNotFoundException extends RuntimeException {
        public ReviewNotFoundException(Long productId) {
            super("Reviews not found for product id: " + productId);
        }
    }

}
