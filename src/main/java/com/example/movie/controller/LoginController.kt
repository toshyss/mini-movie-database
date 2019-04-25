package com.example.movie.controller

import com.example.movie.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController @Autowired constructor(private val userService: UserService) {

    @RequestMapping("/", "/index")
    fun root(): ModelAndView {
        return ModelAndView("/index")
    }

    @RequestMapping("/login/success")
    fun success(): ModelAndView = ModelAndView("/login/success")
}