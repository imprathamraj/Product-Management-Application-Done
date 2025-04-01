package com.application.ProductManagementAppUsingSpringBootWeb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        return httpSecurity
                // Disabling Csrf
                .csrf(AbstractHttpConfigurer::disable)

                // Enabling Authorising
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())

                // Enabling the form login -> for browser
                //.formLogin(Customizer.withDefaults())

                // Enabling the form login -> for postman -> rest api access
                .httpBasic(Customizer.withDefaults())

                // To make stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .build();
    }

    // Using default username and password form UserDetailService and InMemoryUserDetailsManager
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u1 = User
                .withDefaultPasswordEncoder()
                .username("u1")
                .password("u1")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(u1);
    }


}
