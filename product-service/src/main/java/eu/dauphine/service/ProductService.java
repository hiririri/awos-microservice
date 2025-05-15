package eu.dauphine.service;

import eu.dauphine.dto.ProductResponse;
import eu.dauphine.entity.Product;
import eu.dauphine.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for managing products
 */
@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse findProductById(Long id) {
        return productRepository.findById(id)
                                .map(this::toResponse)
                                .orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                              .productId(product.getId())
                              .name(product.getName())
                              .weight(product.getWeight())
                              .build();
    }

    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

}