package eu.dauphine.configuration;

import eu.dauphine.client.ProductServiceClient;
import eu.dauphine.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceClientFallbackFactory implements FallbackFactory<ProductServiceClient> {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceClientFallbackFactory.class);

    @Override
    public ProductServiceClient create(Throwable throwable) {
        return productId -> {
            logger.error("Fallback for product service. Product ID: {}", productId, throwable);

            return new ProductDto(productId, "Fallback Product", 0.0);
        };
    }
} 