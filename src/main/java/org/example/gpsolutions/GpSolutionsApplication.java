package org.example.gpsolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties
public class GpSolutionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpSolutionsApplication.class, args);
    }

}
