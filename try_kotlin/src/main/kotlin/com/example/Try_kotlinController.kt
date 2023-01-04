package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

//@ExecuteOn(TaskExecutors.IO) //It is critical that any blocking I/O operations (such as fetching the data from the database) are offloaded to a separate thread pool that does not block the Event loop.
@Controller("/try_kotlin")
class Try_kotlinController(@Inject val service: GreetingService) {

    @Get(uri="/", produces=["text/plain"])
    fun index(): String {
        return service.getGreeting() + "Example Response"
    }
}