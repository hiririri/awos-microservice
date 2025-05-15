package eu.dauphine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateDto {

    private ProductDto product;

    private List<ReviewDto> reviews;

    private List<RecommendationDto> recommendations;

}
