package com.honeygoose.wifiadmin.service.mapping

import com.honeygoose.wifiadmin.model.ReportEntity
import com.honeygoose.wifiadmin.model.client.Report
import org.springframework.stereotype.Service

@Service
class ReportMapper {
    fun map(report: Report): ReportEntity = ReportEntity(
            login = report.login,
            data = report.wiFiData,
            deviceDetails = report.deviceDetails,
            lat = report.lat,
            lon = report.lon,
            address = report.address
    )

    fun map(source: ReportEntity): Report =
            Report(
                    login = source.login,
                    wiFiData = source.data,
                    deviceDetails = source.deviceDetails,
                    lat = source.lat,
                    lon = source.lon,
                    address = source.address
            )
}