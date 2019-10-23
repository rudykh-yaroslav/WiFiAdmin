package com.honeygoose.wifiadmin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("com.honeygoose")
class WiFiAdminApplication

fun main(args: Array<String>) {
    runApplication<WiFiAdminApplication>(*args)
}
