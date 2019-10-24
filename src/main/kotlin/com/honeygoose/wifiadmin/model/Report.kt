package com.honeygoose.wifiadmin.model

import com.honeygoose.wifiadmin.model.client.WiFiData
import java.time.LocalDateTime


data class Report(
        val id: Long? = null,

        val data: WiFiData,

        var createdTime: LocalDateTime? = null,

        var modifiedTime: LocalDateTime? = null
) {

}