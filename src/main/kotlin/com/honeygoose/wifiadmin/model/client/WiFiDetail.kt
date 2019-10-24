package com.honeygoose.wifiadmin.model.client

data class WiFiDetail(
        private val SSID: String,
        val bssid: String,
        val capabilities: String,
        val wiFiSignal: WiFiSignal,
        val wiFiAdditional: WiFiAdditional,
        val timestamp: Long)