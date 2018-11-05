package com.halo.model
import lombok.Data;

@Entity
@Data
//@Table(name = "\"feed\"")
data class Feed (
    @Id
    @GeneratedValue
    val id: Long,
    val message: String,
    val userName: String,
    val registDate: String
) {}
