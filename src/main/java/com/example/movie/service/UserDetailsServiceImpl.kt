package com.example.movie.service

import com.example.movie.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
open class UserDetailsServiceImpl : UserDetailsService {
    @Autowired
    lateinit var userService: UserService

    override fun loadUserByUsername(email: String): UserDetails {
        var user : User? = null
        try {
            user = userService.findByEmail(email)
        } catch (e:Exception) {
            throw UsernameNotFoundException("Can not get any User")
        }

        if(user == null) {
            throw UsernameNotFoundException("User not exists")
        }

        return LoginUser(user)
    }
}