package eu.dauphine.client;

import eu.dauphine.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",
    url = "http://localhost:8081",
             path = "/api/v1")
public interface ProductServiceClient {

    @GetMapping("/products/{productId}")
    ProductDto getProductById(@PathVariable("productId") Long productId);

}
