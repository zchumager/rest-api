package com.itexico.restapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
open class RestApiApplication

fun main(args: Array<String>) {
	runApplication<RestApiApplication>(*args)
}
