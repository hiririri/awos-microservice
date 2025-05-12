package eu.dauphine.aows.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private Long reviewId;
    private Long productId;
    private String author;
    private String subject;
    private String content;

}
