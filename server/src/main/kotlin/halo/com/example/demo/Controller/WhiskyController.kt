package com.sample.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import com.sample.entity.Whisky
import com.sample.service.WhiskyService

@RestController
@RequestMapping("api/whiskies")
class WhiskyController {
    @Autowired
    internal var whiskyService: WhiskyService? = null

    internal val whiskies: List<Whisky>
        @RequestMapping(method = RequestMethod.GET)
        get() = whiskyService!!.findAll()

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    internal fun insertWhisky(@Validated @RequestBody whisky: Whisky): Whisky {
        return whiskyService!!.save(whisky)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    internal fun updateWhisky(@PathVariable("id") id: Long, @Validated @RequestBody whisky: Whisky): Whisky {
        whisky.setId(id)
        return whiskyService!!.save(whisky)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    internal fun deleteWhisky(@PathVariable("id") id: Long) {
        whiskyService!!.delete(id)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    internal fun getWhisky(@PathVariable("id") id: Long): Whisky {
        return whiskyService!!.find(id)
    }
}
