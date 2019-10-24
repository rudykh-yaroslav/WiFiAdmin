package com.honeygoose.wifiadmin.service.mapping

import com.honeygoose.wifiadmin.model.Report
import com.honeygoose.wifiadmin.model.ReportEntity
import org.springframework.stereotype.Service

@Service
class ReportMapper {
    fun map(source: Report) : ReportEntity = ReportEntity(
            data = source.data
    )

    fun map(source: ReportEntity) : Report = Report(
            id = source.id,
            data = source.data//,
//            createdTime = source.createdTime,
////            modifiedTime = source.modifiedTime
    )
}