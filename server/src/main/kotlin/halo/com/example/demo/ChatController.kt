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

    @GetMapping("/hello")
    fun hello(): String  {
        return "Hello World!"
    }

    @GetMapping("/samplemessage")
    @ResponseBody
    fun sampleMessage(): Feed {
        val feed = Feed(1, "hoge", "satou", "2019/07/18")
        return feed
    }

    @GetMapping("/")
    fun index(model :Model): String  {
        logger.info("index action")
        val feedlist: List<Feed> = repository.findAll()
        return feedlist
    }

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun index(model :Model): String  {
        logger.info("Hello Logback!!")
        var emplist: List<Employee> = empRepository.findAll()
        model.addAttribute("emplist", emplist)

        return "index"
    }

    @GetMapping("/hello")
    fun hello(model :Model): String  {
        logger.info("hello action")
        model.addAttribute("message", "Hello Thmeleaf")
        return "hello"
    }
}