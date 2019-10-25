package com.honeygoose.wifiadmin.service

import com.honeygoose.wifiadmin.model.client.Report
import com.honeygoose.wifiadmin.repo.ReportRepository
import com.honeygoose.wifiadmin.service.mapping.ReportMapper
import org.springframework.stereotype.Service

@Service
class ReportService(
        private val reportRepository: ReportRepository,
        private val reportMapper: ReportMapper
) {
    fun putReport(report: Report) = reportMapper.map(report).also { reportRepository.save(it) }

    fun getReport(id: Long): Report = reportRepository.getById(id).let { reportMapper.map(it) }

    fun getReports(): List<Report> = reportRepository.findAll().map { reportMapper.map(it) }
}