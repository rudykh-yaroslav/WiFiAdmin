package com.honeygoose.wifiadmin.service.mapping

import com.honeygoose.wifiadmin.model.ReportEntity
import com.honeygoose.wifiadmin.model.client.WiFiData
import org.springframework.stereotype.Service

@Service
class ReportMapper {
    fun map(source: WiFiData): ReportEntity = ReportEntity(
            data = source
    )

    fun map(source: ReportEntity): WiFiData = source.data
}