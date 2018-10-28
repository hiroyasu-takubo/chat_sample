package com.halo.repository

// entityとmodelの違いがよくわかってない
import com.halo.model.Feed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository : JpaRepository<Feed, String> {
    fun findById(id: Long): Optional<Feed>
}