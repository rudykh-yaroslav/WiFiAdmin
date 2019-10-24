package com.honeygoose.wifiadmin.model.client

data class WiFiChannels(val wiFiRange: Pair<Int, Int>? = null,
                        val wiFiChannelPairs: List<Pair<WiFiChannel, WiFiChannel>>? = null)