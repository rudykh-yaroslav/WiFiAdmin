package com.honeygoose.wifiadmin.model.client

import com.fasterxml.jackson.annotation.JsonProperty

data class WiFiSignal(val primaryFrequency: Int? = null,
                      val centerFrequency: Int? = null,
                      val wiFiWidth: WiFiWidth? = null,
                      val level: Int? = null//,
//                      @JsonProperty("is80211mc")
//                      val is80211mc: Boolean? = null
)
