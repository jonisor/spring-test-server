package com.example.springy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class SpringyApplication {

	@GetMapping
	fun start() = "REST Api"

}

fun main(args: Array<String>) {
	runApplication<SpringyApplication>(*args)
}
