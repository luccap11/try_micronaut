package com.example;

import io.micronaut.context.annotation.Bean;

@Bean(typed = GreetingService.class)
public class DefaultGreetingService implements GreetingService {

    public String getGreeting() {
        return "Sono passato dal service: ";
    }
}
