package com.honeygoose.wifiadmin.controller

import com.honeygoose.wifiadmin.model.Report
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import mu.KotlinLogging
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
@Api(description = "API Wi Fi Admin")
class WiFiAdminController {

    @ResponseStatus(CREATED)
    @PostMapping("/report")
    @ApiOperation(value = "Отправка документов по сделке в ECM", response = String::class)
    fun sendToEcm(
            @Valid
            @RequestBody
            @ApiParam("Отчет о сканировании WiFi")
            report: Report
    ) =
            LOG.info { "Received Wi Fi Report" }
                    .let { "OK" }


    companion object {
        private val LOG = KotlinLogging.logger { }
    }
}