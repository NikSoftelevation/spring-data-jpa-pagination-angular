package com.spring.pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaPaginationApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedOrigins(Arrays.asList("*"));

        configuration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin",
                "Content-Type", "Accept", "Jwt-Token", "Authorization", "Origin,Accept", "" +
                        "X Requested With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));


        configuration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "File Name"));

        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));

        source.registerCorsConfiguration("/**", configuration);

        return new CorsFilter(source);
    }
}