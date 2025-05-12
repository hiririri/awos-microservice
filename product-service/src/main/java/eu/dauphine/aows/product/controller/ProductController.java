package eu.dauphine.aows.product.controller;

import eu.dauphine.aows.product.dto.ProductResponse;
import eu.dauphine.aows.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ProductResponse getProductById(@PathVariable("productId") Long productId) {
        return productService.findProductById(productId);
    }

} 