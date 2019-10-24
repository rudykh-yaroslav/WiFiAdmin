package com.honeygoose.wifiadmin.model.client

import com.fasterxml.jackson.annotation.JsonProperty

data class WiFiConnection(
        @JsonProperty("SSID")
        val ssid: String? = null,
        @JsonProperty("BSSID")
        val bssid: String? = null,
        val ipAddress: String? = null,
        val linkSpeed: Int = 0
)
