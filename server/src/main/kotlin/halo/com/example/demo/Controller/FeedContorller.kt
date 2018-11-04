package com.halo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.halo.repository.FeedRepository

@RestController
@RequestMapping("/api/feed")
class FeedController constructor(val repository: FeedRepository){
    @Autowired
    internal var feedService: FeedService? = null

    internal val feeds: List<Feed>
        @RequestMapping(method = RequestMethod.GET)
        get() = feedService!!.findAll()

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    internal fun insertFeed(@Validated @RequestBody feed: Feed): Feed {
        return feedService!!.save(feed)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    internal fun updateFeed(@PathVariable("id") id: Long, @Validated @RequestBody feed: Feed): Feed {
        feed.setId(id)
        return feedService!!.save(feed)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    internal fun deleteFeed(@PathVariable("id") id: Long) {
        feedService!!.delete(id)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    internal fun getFeed(@PathVariable("id") id: Long): Feed {
        return feedService!!.find(id)
    }


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

@RestController
@RequestMapping("api/feeds")
class FeedController {
    @Autowired
    internal var feedService: FeedService? = null

    internal val whiskies: List<Feed>
        @RequestMapping(method = RequestMethod.GET)
        get() = feedService!!.findAll()

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    internal fun insertFeed(@Validated @RequestBody Feed: Feed): Feed {
        return feedService!!.save(Feed)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    internal fun updateFeed(@PathVariable("id") id: Long, @Validated @RequestBody Feed: Feed): Feed {
        Feed.setId(id)
        return feedService!!.save(Feed)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    internal fun deleteFeed(@PathVariable("id") id: Long) {
        feedService!!.delete(id)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    internal fun getFeed(@PathVariable("id") id: Long): Feed {
        return feedService!!.find(id)
    }
}