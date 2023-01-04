package com.example.model;

import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Singleton
public class DefaultUserRepository implements UserRepository {
    private final EntityManager entityManager;

    public DefaultUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly//All database access needs to be wrapped inside a transaction. As the method only reads data from the database, annotate it with @ReadOnly.
    public Optional<UserDto> findById(long id) {
        return Optional.ofNullable(entityManager.find(UserDto.class, id));
    }

    @Override
    @Transactional//This method modifies the database, thus it is annotated with @Transactional.
    public UserDto save(@NotBlank String name) {
        UserDto userDto = new UserDto();
        userDto.setUsername(name);
        userDto.setPassword("pwd");
        entityManager.persist(userDto);
        return userDto;
    }

    @Override
    @ReadOnly//All database access needs to be wrapped inside a transaction. As the method only reads data from the database, annotate it with @ReadOnly.
    public List<UserDto> findAll() {
        String qlString = "SELECT u FROM UserDto as u";
        TypedQuery<UserDto> query = entityManager.createQuery(qlString, UserDto.class);
        return query.getResultList();
    }
}
