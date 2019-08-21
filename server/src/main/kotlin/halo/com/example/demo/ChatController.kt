package halo.com.example.demo

import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.ui.Model
import halo.com.example.demo.FeedRepository
import halo.com.example.demo.Feed
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
class ChatController constructor(val repository: FeedRepository){

    private val logger = LoggerFactory.getLogger(ChatController::class.java)

    @GetMapping("hello")
    fun hello(): String  {
        return "Hello World!"
    }

    @GetMapping("samplemessage")
    @ResponseBody
    fun sampleMessage(): Feed {
        val feed = Feed(1, "hoge", "satou", "2019/07/18")
        return feed
    }

    @GetMapping("/")
    fun index(model :Model): String  {
        logger.debug("debug");
        logger.info("Hello Logback!!")
        logger.warn("warn");
        logger.error("error");
        val feedlist: List<Feed> = repository.findAll()
        model.addAttribute("feedlist", feedlist)
//        logger.info("called index")
        return "index"
    }

     GET のみ対応
    axiosを使う際は普通にjsonを返してやればajax通信ができる。
    val sample: String
        @GetMapping("getsample")
        get() = "ok getsample"

     すべての HTTP メソッドに対応
    @RequestMapping("api/greeting")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}