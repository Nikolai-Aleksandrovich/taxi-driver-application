package com.calculator.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author Yuyuan Huang
 * @create 2021-05-01 22:11
 */
@Configuration
public class RestClientConfiguration {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public Traverson getTraverson(){
        return new Traverson(
                URI.create("http://localhost:8080/api"), MediaTypes.HAL_JSON
        );
    }



}
