package com.kodilla.ecommercee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Timer;

@Configuration
public class BeanConfiguration {

    @Bean
    public Random createGenerator() {
        return new Random();
    }

    @Bean
    public Timer createTimer() {
        return new Timer();
    }
}
