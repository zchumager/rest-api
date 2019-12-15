package com.itexico.restapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("restapi/home")
class HomeController {

    @GetMapping("/")
    fun home(): String
            = "Welcome to Rest API Kotlin Demo"
}
