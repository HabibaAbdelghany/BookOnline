package com.bookOline.bookOline.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeRequests().anyRequest().authenticated().and();
        return  http.build();

    }
}