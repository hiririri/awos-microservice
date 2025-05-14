package eu.dauphine.aows.review.service;

import eu.dauphine.aows.review.dto.ReviewResponse;
import eu.dauphine.aows.review.entity.Review;
import eu.dauphine.aows.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getReviewByProductId(Long productId) {
        return reviewRepository.findByProductId(productId).stream()
                               .map(this::mapToReviewResponse)
                               .toList();

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
