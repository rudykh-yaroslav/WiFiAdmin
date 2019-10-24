package com.honeygoose.wifiadmin.model

import java.math.BigInteger
import java.time.LocalDateTime


data class Report(
        val id: Long? = null,

        val data: String,

        var createdTime: LocalDateTime? = null,

        var modifiedTime: LocalDateTime? = null
) {

}