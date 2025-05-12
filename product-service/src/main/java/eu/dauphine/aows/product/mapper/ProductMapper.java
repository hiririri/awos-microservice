package eu.dauphine.aows.product.mapper;

import eu.dauphine.aows.product.dto.ProductRequest;
import eu.dauphine.aows.product.dto.ProductResponse;
import eu.dauphine.aows.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        return Product.builder()
                      .name(request.getName())
                      .weight(request.getWeight())
                      .build();
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                              .productId(product.getId())
                              .name(product.getName())
                              .weight(product.getWeight())
                              .build();
    }

} 