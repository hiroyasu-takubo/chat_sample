package com.halo.controller

import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.halo.repository.FeedRepository
import com.halo.model.Feed

@RestController
class ChatController constructor(val repository: FeedRepository){

    @GetMapping("api/hello")
    fun hello(): String  {
        return "Hello World!"
    }

    @GetMapping("api/samplemessage")
    @ResponseBody
    fun sampleMessage(): Feed {
        val feed = Feed(1, "hoge", "satou", "2019/07/18")
        return feed
    }

    // GET のみ対応
    //axiosを使う際は普通にjsonを返してやればajax通信ができる。
    val sample: String
        @GetMapping("api/getsample")
        get() = "ok getsample"

    // すべての HTTP メソッドに対応
    @RequestMapping("api/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}