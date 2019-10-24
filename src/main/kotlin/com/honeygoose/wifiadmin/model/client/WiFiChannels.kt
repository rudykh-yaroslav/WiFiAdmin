package com.honeygoose.wifiadmin.model.client

data class WiFiChannels(private val wiFiRange: Pair<Int, Int>,
                        private val wiFiChannelPairs: List<Pair<WiFiChannel, WiFiChannel>>)