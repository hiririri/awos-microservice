package eu.dauphine.configuration;

import eu.dauphine.client.ReviewServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ReviewServiceClientFallbackFactory implements FallbackFactory<ReviewServiceClient> {

    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceClientFallbackFactory.class);

    @Override
    public ReviewServiceClient create(Throwable cause) {
        return productId -> {
            logger.error("Fallback for review service, product ID: {}", productId, cause);
            return Collections.emptyList();
        };
    }

}
