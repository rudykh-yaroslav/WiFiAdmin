package com.honeygoose.wifiadmin.controller

import io.swagger.annotations.ApiOperation
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import javax.validation.Valid


@RestController
@RequestMapping("/speedtest")
class SpeedTestController {
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/upload")
    @ApiOperation(value = "Тестирование скорости загрузки файла", response = String::class)
    fun upload(
            @Valid
            @RequestBody filePlusTimestamp: FilePlusTimestamp
    ) = LOG.info { "uploaded" }
            .let { filePlusTimestamp.timestamp }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/download")
    @ApiOperation(value = "Тестирование скорости скачивания файла", response = String::class)
    fun download(
            @RequestParam("timestamp") timestamp: Timestamp
    ) = LOG.info { "downloaded" }
            .let {
                FilePlusTimestamp(
                        ByteArray(SPEEDTEST_FILE_SIZE),
                        timestamp
                )
            }

    data class FilePlusTimestamp(
            val file: ByteArray,
            val timestamp: Timestamp
    )

    companion object {
        private val LOG = KotlinLogging.logger { }
        private val SPEEDTEST_FILE_SIZE = 1000000
    }
}