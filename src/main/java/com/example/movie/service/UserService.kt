package com.example.movie.service

import com.example.movie.domain.User
import com.example.movie.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class UserService @Autowired constructor(private val userRepository: UserRepository) {
    fun findByEmail(email: String): User = userRepository.findByEmail(email);
}