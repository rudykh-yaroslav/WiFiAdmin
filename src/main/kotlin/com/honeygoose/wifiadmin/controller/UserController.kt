package com.honeygoose.wifiadmin.controller

import com.honeygoose.wifiadmin.model.client.UserData
import com.honeygoose.wifiadmin.service.UserService
import org.hibernate.service.spi.ServiceException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController(var userService: UserService) {
    @PostMapping("/login")
    fun getToken(
            @Valid
            @RequestBody
            userData: UserData
    ): String {
        return userService.login(userData.login, userData.password)
    }

    @ExceptionHandler(ServiceException::class)
    fun handler(): String {
        return "Something went wrong"
    }
}