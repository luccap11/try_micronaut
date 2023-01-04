package com.example

import io.micronaut.context.annotation.Bean

@Bean(typed = [GreetingService::class])
class DefaultGreetingService: GreetingService {
    override fun getGreeting(): String {
        return "Sono passato dal service: "
    }
}