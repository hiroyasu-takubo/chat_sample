package com.halo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@RestController
class HelloController {

    // GET のみ対応
    val sample: String
        @GetMapping("/getsample")
        get() = "ok getsample"

    // すべての HTTP メソッドに対応
    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }

    // POST のみ対応
    @PostMapping("/postsample")
    fun postSample(): String {
        return "ok postSample"
    }
}