package com.example.movie

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFailureHandler : AuthenticationFailureHandler {
    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(httpServletRequest: HttpServletRequest,
                                         httpServletResponse: HttpServletResponse,
                                         authenticationException: AuthenticationException) {
        var errorCode = ""

        if(authenticationException is BadCredentialsException) {
            errorCode = "403"
        }
        httpServletResponse.sendRedirect(httpServletRequest.contextPath + "/index?error=" + errorCode)
    }
}