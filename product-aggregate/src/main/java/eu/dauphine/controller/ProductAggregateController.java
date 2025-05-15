package eu.dauphine.controller;

import eu.dauphine.dto.AggregateDto;
import eu.dauphine.service.ProductAggregateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-aggregates")
@RequiredArgsConstructor
@Slf4j
public class ProductAggregateController {

    private final ProductAggregateService productAggregateService;

    @GetMapping("/{productId}")
    public AggregateDto getProductById(@PathVariable("productId") Long productId) {
        return productAggregateService.getProductById(productId);
    }

}
