package com.halo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.halo.repository.FeedRepository

@RestController
@RequestMapping("/feed")
class FeedController constructor(val repository: FeedRepository){

//    var respository: FeedRepository;
//    fun ChatController(FeedRepository repository) {this.repository = repository}

//    @GetMapping("/greet")
//    public Collection<Feed> greet()

    @GetMapping("/greet")
    fun greet(): String  {
        return "Hello World!"
    }

    // GET のみ対応
    val sample: String
        @GetMapping("/getsample")
        get() = "ok getsample"

//    // POST のみ対応
//    @PostMapping("/postsample")
//    fun postSample(): String {
//        return "ok postSample"
//    }

//    // すべての HTTP メソッドに対応
//    @RequestMapping("/")
//    fun index(): String {
////        return "Greetings from Spring Boot!"
//        return repository.findAll();
//    }


}