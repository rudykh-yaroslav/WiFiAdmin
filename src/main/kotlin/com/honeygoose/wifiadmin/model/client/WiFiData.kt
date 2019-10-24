package com.honeygoose.wifiadmin.model.client

data class WiFiData(
        val login: String,
        val wiFiDetails: List<WiFiDetail>? = null,
        val wiFiConnection: WiFiConnection? = null,
        val lat: Double? = null,
        val lon: Double? = null,
        val address: String? = null
)
