package eu.dauphine.configuration;

import eu.dauphine.client.RecommendationServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RecommendationServiceClientFallbackFactory implements FallbackFactory<RecommendationServiceClient> {

    private static final Logger logger = LoggerFactory.getLogger(RecommendationServiceClientFallbackFactory.class);

    @Override
    public RecommendationServiceClient create(Throwable cause) {
        return productId -> {
            logger.error("Fallback for recommendation service, product ID: {}", productId, cause);
            return Collections.emptyList();
        };
    }

}
