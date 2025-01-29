package com.global.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AppConfig implements WebMvcConfigurer {

    String [] allowedOrgins={"http://localhost:4200","https://google.com"};
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();}

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**").allowedOrigins("http://localhost:4200")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS");

    }
}