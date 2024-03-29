package com.honeygoose.wifiadmin.controller

import com.honeygoose.wifiadmin.model.LoginData
import com.honeygoose.wifiadmin.model.RegistrationData
import com.honeygoose.wifiadmin.model.UserRole
import com.honeygoose.wifiadmin.model.client.Report
import com.honeygoose.wifiadmin.service.ReportService
import com.honeygoose.wifiadmin.service.UserService
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
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
@Api(description = "API Wi Fi Admin")
class WiFiAdminController(
        private val reportService: ReportService,
        private val userService: UserService
) {
    val roles = UserRole.values().map { it.code }.toList()

    @ResponseStatus(CREATED)
    @PostMapping("/report")
    @ApiOperation(value = "Сохранить отчёт", response = String::class)
    fun createReport(
            @Valid
            @RequestBody
            @ApiParam("Отчет о сканировании WiFi")
            report: Report
    ) =
            LOG.info { "Received Report: ${report}" }
                    .also { LOG.info { "THIS: ${report.wiFiData.wiFiConnection?.ssid}" } }
                    .also { reportService.putReport(report) }
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

    @ResponseStatus(OK)
    @GetMapping("/report/all")
    @ApiOperation(value = "Запросить все отчеты", response = String::class)
    fun getReports() =
            LOG.info { "Requested Wi Fi Reports" }
                    .let { reportService.getReports() }

    @ResponseStatus(OK)
    @PostMapping("/login")
    @ApiOperation(value = "Авторизоваться", response = String::class)
    fun login(
            @Valid
            @RequestBody
            @ApiParam("Аутентификаицонные данные")
            loginData: LoginData
    ) =
            LOG.info { "Authorized" }
                    .let {
                        userService.login(loginData.login, loginData.password)
                    }

    @ResponseStatus(OK)
    @PostMapping("/admin/create")
    @ApiOperation(value = "Создание пользователя", response = String::class)
    fun createUser(
            @Valid
            @RequestBody
            @ApiParam("Регистрационные данные")
            registrationData: RegistrationData
    ): String {
        if (!roles.contains(registrationData.role)) {
            return "Registration of user with role '${registrationData.role}' is not possible"
        }
        return LOG.info { "Register user" }
                .let {
                    userService.createUser(registrationData)
                }
    }

    companion object {
        private val LOG = KotlinLogging.logger { }
    }
}