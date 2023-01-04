package com.example.model

import javax.validation.constraints.NotBlank

interface UserRepository {
    fun findById(id: Long): UserDto?
    fun save(name: @NotBlank String): UserDto?

    //    UserDto saveWithException(@NotBlank String name);
    fun findAll(): List<UserDto>?
}