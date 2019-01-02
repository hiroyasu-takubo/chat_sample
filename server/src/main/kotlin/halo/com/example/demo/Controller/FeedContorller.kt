package com.halo.controller

import org.springframework.web.bind.annotation.GetMapping
import com.halo.repository.FeedRepository
import com.halo.service.FeedService
import com.halo.model.Feed
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated

import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Optional


@RequestMapping
class FeedController constructor(val repository: FeedRepository){
    @Autowired
    internal var feedService: FeedService? = null

    internal val feeds: List<Feed>
        @RequestMapping(method = [RequestMethod.GET])
        get() = feedService!!.findAll()

    @RequestMapping(method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    internal fun insertFeed(@Validated @RequestBody feed: Feed): Feed {
        return feedService!!.save(feed)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    internal fun updateFeed(@PathVariable("id") id: Long, @Validated @RequestBody feed: Feed): Feed {
        feed.id =id
        return feedService!!.save(feed)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    internal fun deleteFeed(@PathVariable("id") id: Long) {
        feedService!!.deleteById(id)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.GET])
    internal fun getFeed(@PathVariable("id") id: Long): Optional<Feed> {
        return feedService!!.findById(id)
    }

    @GetMapping("/greet")
    fun greet(): String  {
        return "Hello World!"
    }
}