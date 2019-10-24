package com.honeygoose.wifiadmin.model.client

data class WiFiConnection(
        private val SSID: String? = null,
        private val BSSID: String? = null,
        private val ipAddress: String? = null,
        private val linkSpeed: Int = 0
)
