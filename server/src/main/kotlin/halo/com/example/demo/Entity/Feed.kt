package com.halo.model
import lombok.Data;

@Entity
@Data
data class Feed (
    val id: Long,
    val message: String,
    val username: String,
    val registDate: String
) {}
