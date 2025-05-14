package eu.dauphine.aows.aggregate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ProductAggregateApplication {

    public static void main(String[] args) {
        run(ProductAggregateApplication.class, args);
    }

}
