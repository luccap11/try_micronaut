package com.example;

import com.example.model.UserDto;
import com.example.model.UserRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jakarta.inject.Inject;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Micronaut Launch",
                version = "${api.version}",
                description = "API for Creating Micronaut Applications",
                license = @License(name = "Apache 2.0")
        )
)
@ExecuteOn(TaskExecutors.IO)//It is critical that any blocking I/O operations (such as fetching the data from the database) are offloaded to a separate thread pool that does not block the Event loop.
@Controller("/try_java")//The class is defined as a controller with the @Controller annotation mapped to the path /try_java
public class Try_javaController {

    @Inject//puoi usare l'annotation o il costrutture
    private GreetingService service;
    private final UserRepository repository;

    public Try_javaController(UserRepository repository) {//Constructor injection
        this.repository = repository;
    }

    @Get(uri="/", produces="text/plain")
    public String index() {
        List<UserDto> users = repository.findAll();
        return "Example Response " + users;
    }

    @Get("/{name}")
    public String greet(String name) {
        return service.getGreeting() + name;
    }

    @Post(value = "/{name}", consumes = MediaType.TEXT_PLAIN)
    public String setGreeting(@Body String credentials, @PathVariable String name) {
        System.err.println(credentials);

        repository.save(name);
        return service.getGreeting() + name;
    }
}