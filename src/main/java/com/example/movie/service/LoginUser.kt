package com.example.movie.service

import com.example.movie.domain.User
import org.springframework.security.core.authority.AuthorityUtils

class LoginUser(user: User): org.springframework.security.core.userdetails.User(user.email, user.password,
        AuthorityUtils.createAuthorityList("ROLE_USER")) {

    var loginUser: User? = null

    init {
        this.loginUser = user
    }
}