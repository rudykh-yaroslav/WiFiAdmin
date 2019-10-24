package com.honeygoose.wifiadmin.controller

import com.honeygoose.wifiadmin.model.Report
import com.honeygoose.wifiadmin.service.ReportService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import mu.KotlinLogging
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
@Api(description = "API Wi Fi Admin")
class WiFiAdminController(
        private val reportService: ReportService
) {

    @ResponseStatus(CREATED)
    @PostMapping("/report")
    @ApiOperation(value = "Сохранить отчёт", response = String::class)
    fun createReport(
            @Valid
            @RequestBody
            @ApiParam("Отчет о сканировании WiFi")
            report: Report
    ) =
            LOG.info { "Received Wi Fi Report" }.
                    also { reportService.putReport(report) }
                    .let { "OK" }

    @ResponseStatus(OK)
    @GetMapping("/report/{report_id}")
    @ApiOperation(value = "Запросить отчёт", response = String::class)
    fun getReport(
            @Valid
            @PathVariable("report_id") id: Long
    ) =
            LOG.info { "Requested Wi Fi Report" }
                    .let { reportService.getReport(id) }

    companion object {
        private val LOG = KotlinLogging.logger { }
    }
}