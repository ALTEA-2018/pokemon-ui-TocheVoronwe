package com.miage.altea.tp.pokemon_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Configuration
public class RestConfiguration {

    @Value("${spring.security.user.name)")
    private String username;
    @Value("${spring.security.user.password")
    private String password;

    @Bean
    RestTemplate trainerApiRestTemplate() {
        var restTemplate = new RestTemplate();
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(0, new BasicAuthenticationInterceptor(username, password));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;

    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}