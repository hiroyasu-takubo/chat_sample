package halo.com.example.demo

import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import halo.com.example.demo.FeedRepository
import halo.com.example.demo.EmployeeRepository
import halo.com.example.demo.Employee
import halo.com.example.demo.Feed
import org.slf4j.LoggerFactory
import org.slf4j.Logger

@Controller
class HeloController constructor(val repository: FeedRepository, val empRepository: EmployeeRepository){
    private val logger = LoggerFactory.getLogger(HeloController::class.java)

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
//    @GetMapping("/")
    fun index(model :Model): String  {
        logger.info("Hello Logback!!")
        logger.warn("warn");
        logger.error("error");
//        val feedlist: List<Feed> = repository.findAll()
//        model.addAttribute("feedlist", feedlist)
//        logger.info("called index")
        var emplist: List<Employee> = empRepository.findAll()
        model.addAttribute("emplist", emplist)

//        throw Error()
        return "index"
    }

    @GetMapping("/hello")
//    @RequestMapping(value = ["/hello"], method = [RequestMethod.GET])
    fun hello(model :Model): String  {
        logger.info("hello action")
        model.addAttribute("message", "Hello Thmeleaf")
        return "hello"
    }
}