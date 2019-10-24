package com.honeygoose.wifiadmin.model.client

import com.fasterxml.jackson.annotation.JsonProperty

data class WiFiDetail(
        @JsonProperty("SSID")
        val ssid: String? = null,
        @JsonProperty("BSSID")
        val bssid: String? = null,
        val capabilities: String? = null,
        val wiFiSignal: WiFiSignal? = null,
        val wiFiAdditional: WiFiAdditional? = null,
        val timestamp: Long? = null)