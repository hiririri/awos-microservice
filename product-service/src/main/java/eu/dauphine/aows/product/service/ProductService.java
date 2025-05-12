package eu.dauphine.aows.product.service;

import eu.dauphine.aows.product.dto.ProductResponse;
import eu.dauphine.aows.product.mapper.ProductMapper;
import eu.dauphine.aows.product.repository.ProductRepository;
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

    private final ProductMapper mapper;

    public ProductResponse findProductById(Long id) {
        return productRepository.findById(id)
                                .map(mapper::toResponse)
                                .orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
    }

    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

}