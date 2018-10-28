package com.sample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

//import com.sample.entity.Feed
//import com.sample.repository.WhiskyRepository
import com.halo.model.Feed
import com.halo.model.FeedRepository


@Service
@Transactional
class FeedService {
    @Autowired
    internal var feedRepository: FeedRepository? = null

    fun findAll(): List<Feed> {
        return feedRepository!!.findAll(Sort(Sort.Direction.ASC, "id"))
    }

    fun save(feed: Feed): Feed {
        return feedRepository!!.save(feed)
    }

    fun delete(id: Long) {
        feeedRepository!!.delete(id)
    }

    fun find(id: Long): Feed {
        return feedRepository!!.findOne(id)
    }
}