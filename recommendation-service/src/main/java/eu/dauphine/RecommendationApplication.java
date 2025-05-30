package eu.dauphine;

import eu.dauphine.entity.Recommendation;
import eu.dauphine.repository.RecommendationRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableDiscoveryClient
public class RecommendationApplication {

    public static void main(String[] args) {
        run(RecommendationApplication.class, args);
    }

    @Component
    public static class DataInitializer {
        public DataInitializer(RecommendationRepository recommendationRepository) {
            recommendationRepository.saveAll(List.of(
                    Recommendation.builder().productId(1L).author("John").content("Recommendation 1").build(),
                    Recommendation.builder().productId(2L).author("Jack").content("Recommendation 2").build(),
                    Recommendation.builder().productId(3L).author("Jill").content("Recommendation 3").build()
                                                    ));
        }
    }

}
