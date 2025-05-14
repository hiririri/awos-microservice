package eu.dauphine.aows.aggregate.client;

import eu.dauphine.aows.aggregate.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",
             path = "/api/v1")
public interface ProductServiceClient {

    @GetMapping("/products/{productId}")
    ProductDto getProductById(@PathVariable("productId") Long productId);

}
