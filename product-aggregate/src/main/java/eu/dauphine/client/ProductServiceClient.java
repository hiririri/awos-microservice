package eu.dauphine.client;

import eu.dauphine.configuration.ProductServiceClientFallbackFactory;
import eu.dauphine.dto.ProductDto;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",
             path = "/api/v1",
             fallbackFactory = ProductServiceClientFallbackFactory.class)
public interface ProductServiceClient {

    @GetMapping("/products/{productId}")
    @Retry(name = "product-service")
    ProductDto getProductById(@PathVariable("productId") Long productId);

}
