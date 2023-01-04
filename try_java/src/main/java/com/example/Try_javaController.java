package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jakarta.inject.Inject;

@OpenAPIDefinition(
        info = @Info(
                title = "Micronaut Launch",
                version = "${api.version}",
                description = "API for Creating Micronaut Applications",
                license = @License(name = "Apache 2.0")
        )
)
@Controller("/try_java")
public class Try_javaController {

    @Inject
    private GreetingService service;

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Get("/{name}")
    public String greet(String name) {
        return service.getGreeting() + name;
    }

    @Post(value = "/{name}", consumes = MediaType.TEXT_PLAIN)
    public String setGreeting(@Body String credentials, @PathVariable String name) {
        System.err.println(credentials);
        return service.getGreeting() + name;
    }
}