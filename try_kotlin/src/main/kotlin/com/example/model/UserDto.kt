package com.example.model

import javax.persistence.*

@Entity
@Table(name = "user")//costretto ad aggiungere le ' perche user è una parola riservata per H2
open class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    open var id: Long? = null

    @Column(nullable = false)
    open var username: String = ""

    @Column(nullable = false)
    open var password: String = ""

}