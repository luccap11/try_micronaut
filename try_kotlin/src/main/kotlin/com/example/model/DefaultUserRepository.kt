package com.example.model

import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Singleton
open class DefaultUserRepository(@PersistenceContext private val entityManager: EntityManager): UserRepository {

    @ReadOnly //All database access needs to be wrapped inside a transaction. As the method only reads data from the database, annotate it with @ReadOnly.
    override fun findById(id: Long): UserDto? {
        return entityManager.find(UserDto::class.java, id)
    }

    @Transactional //This method modifies the database, thus it is annotated with @Transactional.
    override fun save(name: String): UserDto {
        val userDto = UserDto()
        userDto.username = name
        userDto.password = "pwd"
        entityManager.persist(userDto)
        return userDto
    }

    @ReadOnly //All database access needs to be wrapped inside a transaction. As the method only reads data from the database, annotate it with @ReadOnly.
    override fun findAll(): List<UserDto>? {
        val qlString = "SELECT u FROM UserDto as u"
        val query = entityManager.createQuery(qlString, UserDto::class.java)
        return query.resultList
    }
}