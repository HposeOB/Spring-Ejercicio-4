package com.example.springEjercicio4.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("SpringBoot API REST",
                "Laptops Api Rest", "1.0",
                "www.google.com",
                new Contact("Paco", "www.paco.com", "paco@gmail.com"),
                "MIT", "www.google.com",
                Collections.emptyList());
    }
}
