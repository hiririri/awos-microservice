package eu.dauphine.controller;

import eu.dauphine.dto.ReviewResponse;
import eu.dauphine.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public List<ReviewResponse> getReviewByProductId(@RequestParam("productId") Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

}
