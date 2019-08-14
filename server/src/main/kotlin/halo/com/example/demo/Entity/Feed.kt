package com.halo.model

import lombok.Data
import lombok.RequiredArgsConstructor
import javax.persistence.Column;
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Data
@Entity
@Table(name = "\"feeds\"")
@RequiredArgsConstructor
data class Feed (
    @Id
    @GeneratedValue
    @NotNull
    var id: Long,

    @NotNull
    var message: String,

    @NotNull
    @Column(name="user_name")
    var userName: String,

    @NotNull
    @Column(name="regist_date")
    var registDate: String
) {}
