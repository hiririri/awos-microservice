package eu.dauphine.aows.product;

import eu.dauphine.aows.product.entity.Product;
import eu.dauphine.aows.product.repository.ProductRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        run(ProductApplication.class, args);
    }

    @Component
    public static class DataInitializer {

        public DataInitializer(ProductRepository productRepository) {
            productRepository.saveAll(List.of(
                    Product.builder().name("Product 1").name("Product 1").weight(100.0).build(),
                    Product.builder().name("Product 2").name("Product 2").weight(200.0).build(),
                    Product.builder().name("Product 3").name("Product 3").weight(300.0).build(),
                    Product.builder().name("Product 4").name("Product 4").weight(400.0).build()
                                             ));
        }
    }

}
