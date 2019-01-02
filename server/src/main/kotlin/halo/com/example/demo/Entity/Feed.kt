package com.halo.model;
import lombok.Data
import lombok.RequiredArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Data
@Entity
//@Table(name = "\"feed\"")
@RequiredArgsConstructor
data class Feed (
    @Id
    @GeneratedValue
    var id: Long,
    @NotNull
    var message: String,
    var userName: String,
    var registDate: String
) {}
