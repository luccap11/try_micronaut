package com.example.model

import javax.persistence.*

@Entity
@Table(name = "user")
class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long? = null

    @Column(nullable = false)
    var username: String = ""

    @Column(nullable = false)
    var password: String = ""

}