package eu.dauphine;

import eu.dauphine.entity.Review;
import eu.dauphine.repository.ReviewRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewApplication {

    public static void main(String[] args) {
        run(ReviewApplication.class, args);
    }

    @Component
    public static class DataInitializer {
        public DataInitializer(ReviewRepository reviewRepository) {
            reviewRepository.saveAll(List.of(
                    Review.builder().productId(1L).author("John").content("This is a review").subject("Subject 1").build(),
                    Review.builder().productId(1L).author("John").content("This is another review").subject("Subject 1").build(),
                    Review.builder().productId(2L).author("John").content("This is another review 1").subject("Subject 2").build(),
                    Review.builder().productId(3L).author("John").content("This is another review 2").subject("Subject 3").build()
                                            ));
        }
    }

}
