package eu.dauphine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        run(ConfigServerApplication.class, args);
    }

}
