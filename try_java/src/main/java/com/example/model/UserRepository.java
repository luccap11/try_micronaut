package com.example.model;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<UserDto> findById(long id);
    UserDto save(@NotBlank String name);
//    UserDto saveWithException(@NotBlank String name);
    List<UserDto> findAll();
}
