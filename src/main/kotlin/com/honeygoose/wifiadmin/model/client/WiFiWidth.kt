package com.honeygoose.wifiadmin.model.client

enum class WiFiWidth(// should be two 80 and 80 - feature support
        val frequencyWidth: Int) {
    MHZ_20(20),
    MHZ_40(40),
    MHZ_80(80),
    MHZ_160(160),
    MHZ_80_PLUS(80);

    val frequencyWidthHalf: Int

    init {
        this.frequencyWidthHalf = frequencyWidth / 2
    }
}
