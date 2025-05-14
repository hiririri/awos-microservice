package eu.dauphine.aows.review.controller;

import eu.dauphine.aows.review.dto.ReviewResponse;
import eu.dauphine.aows.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{productId}")
    public List<ReviewResponse> getReviewByProductId(@PathVariable("productId") Long productId) {
        return reviewService.getReviewByProductId(productId);
    }

}
