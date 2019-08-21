package halo.com.example.demo

import halo.com.example.demo.Feed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository : JpaRepository<Feed, String> {
    fun findById(id: Long): Optional<Feed>
}