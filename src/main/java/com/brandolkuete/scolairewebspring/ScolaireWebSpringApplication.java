package com.brandolkuete.scolairewebspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ScolaireWebSpringApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ScolaireWebSpringApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ScolaireWebSpringApplication.class);
    }
}