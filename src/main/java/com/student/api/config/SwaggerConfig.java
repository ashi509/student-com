package com.student.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import static springfox.documentation.builders.PathSelectors.regex;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket  api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.student.api"))
                .paths(regex("/student/.*"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "student management system",
                "student monitoring system",
                "1.0",
                "Terms and service",
                new Contact("Ashish", "URL", "ashishkumar31101999@gmail.com"),
                "License of api",
                "localhost:8089/student-apis/swagger-ui.html",
                Collections.emptyList()
        );
    }
}

