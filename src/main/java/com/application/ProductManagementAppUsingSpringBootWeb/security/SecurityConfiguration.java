package com.application.ProductManagementAppUsingSpringBootWeb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Disabling Csrf
        httpSecurity.csrf(customizer -> customizer.disable());

        // Enabling Authorising
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        // Enabling the form login -> for browser
        httpSecurity.formLogin(Customizer.withDefaults());

        // Enabling the form login -> for postman -> rest api access
        httpSecurity.httpBasic(Customizer.withDefaults());

        // To make stateless
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        return httpSecurity.build();
    }


}
