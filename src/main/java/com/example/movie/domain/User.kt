package com.example.movie.domain

import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id @GeneratedValue var id: Int? = 0,
    @Column var email: String = "",
    @Column var password: String=""
)