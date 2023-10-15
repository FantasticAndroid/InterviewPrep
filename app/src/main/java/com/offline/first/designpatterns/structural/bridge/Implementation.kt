package com.offline.first.designpatterns.structural.bridge

import android.util.Log

interface IDevice{
    fun volume(volume: Int)
    var power: Boolean
    fun power(){
        this.power = !power
    }
    fun getVolume() : Int
    fun getChannel() : Int
    fun setChannel(channelNo: Int)
    fun getBrightness() : Int
    fun setBrightness(brightness: Int)
}

/**
 * Concrete Implementation
 * @property power Boolean
 * @property channelNo Int
 * @property volume Int
 * @property brightness Int
 * @constructor
 */
class TVDevice(override var power: Boolean) : IDevice{
    private var channelNo = 0
    private var volume = 0
    private var brightness = 50

    override fun volume(volume: Int) {
        Log.d(TAG, "set Volume to: $volume")
        this.volume = volume
    }

    override fun getChannel(): Int {
        return channelNo
    }

    override fun setChannel(channelNo: Int) {
        this.channelNo = channelNo
    }

    override fun getBrightness(): Int {
        return brightness
    }

    override fun setBrightness(brightness: Int) {
        this.brightness = brightness
    }

    override fun getVolume(): Int {
        return volume
    }
}

class RadioDevice(override var power: Boolean) : IDevice{
    private var channelNo = 0
    private var volume = 0

    override fun volume(volume: Int) {
        Log.d(TAG, "set Volume to: $volume")
        this.volume = volume
    }

    override fun getChannel(): Int {
        return channelNo
    }

    override fun setChannel(channelNo: Int) {
        this.channelNo = channelNo
    }

    override fun getBrightness(): Int {
        return -1
    }

    override fun setBrightness(brightness: Int) {
        // Not Requireds
    }

    override fun getVolume(): Int {
        return volume
    }
}