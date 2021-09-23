package com.debanshu777.mongoTesting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/ping")
class PingController {
    @GetMapping
    fun ping(): String = "Server is awake"
}
