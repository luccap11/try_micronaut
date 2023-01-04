package com.example

import com.example.model.UserRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import jakarta.inject.Inject

@ExecuteOn(TaskExecutors.IO) //It is critical that any blocking I/O operations (such as fetching the data from the database) are offloaded to a separate thread pool that does not block the Event loop.
@Controller("/try_kotlin")
class Try_kotlinController(@Inject val service: GreetingService, @Inject val repository: UserRepository) {

    @Get(uri="/", produces=["text/plain"])
    fun index(): String {
        val users = repository.findAll()
        return service.getGreeting() + "Example Response $users"
    }

    @Get("/{name}")
    fun greet(name: String): String {
        return service.getGreeting() + name
    }

    @Post(value = "/{name}", consumes = [MediaType.TEXT_PLAIN])
    fun setGreeting(@Body credentials: String?, @PathVariable name: String): String {
        System.err.println(credentials)
        repository.save(name)
        return service.getGreeting() + name
    }
}