package com.honeygoose.wifiadmin.model.client

data class WiFiSignal(val primaryFrequency: Int,
                      val centerFrequency: Int,
                      val wiFiWidth: WiFiWidth,
                      val level: Int,
                      val is80211mc: Boolean
)
