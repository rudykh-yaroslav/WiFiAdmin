package com.honeygoose.wifiadmin.service

import com.honeygoose.wifiadmin.model.client.WiFiData
import com.honeygoose.wifiadmin.repo.ReportRepository
import com.honeygoose.wifiadmin.service.mapping.ReportMapper
import org.springframework.stereotype.Service

@Service
class ReportService(
        private val reportRepository: ReportRepository,
        private val reportMapper: ReportMapper
) {
    fun putReport(wifiData: WiFiData) = reportMapper.map(wifiData).also { reportRepository.save(it) }

    fun getReport(id: Long): WiFiData = reportRepository.getById(id).let { reportMapper.map(it) }
}