package halo.com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import halo.com.example.demo.Feed
import halo.com.example.demo.FeedRepository
import org.springframework.data.domain.Example
import java.util.Optional


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

    fun delete(feed: Feed) {
        feedRepository!!.delete(feed)
    }

    fun deleteById(id: Long) {
        return feedRepository!!.deleteById(id.toString())
    }

    fun find(feed: Feed): Optional<Feed> {
        return feedRepository!!.findOne(Example.of(feed))
    }

    fun findById(id: Long): Optional<Feed> {
        return feedRepository!!.findById(id)
    }

}