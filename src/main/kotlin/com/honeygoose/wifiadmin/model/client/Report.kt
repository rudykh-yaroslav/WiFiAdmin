package com.honeygoose.wifiadmin.model.client

data class Report(
        val login: String,
        val wiFiData: WiFiData,
        val deviceDetails: DeviceDetails,
        val lat: Double? = null,
        val lon: Double? = null,
        val address: String? = null
)