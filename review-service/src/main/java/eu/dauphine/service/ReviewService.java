package eu.dauphine.service;

import eu.dauphine.dto.ReviewResponse;
import eu.dauphine.entity.Review;
import eu.dauphine.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);

        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException(productId);
        }

        return reviews.stream()
                      .map(this::mapToReviewResponse)
                      .toList();
    }

    /* Cleaned up this code by standardizing variable names (e.g. product_id -> productId) and removing debugging statements. Additionally, improved readability by breaking up the code into smaller, more understandable pieces. */

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
