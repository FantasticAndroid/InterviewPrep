package com.offline.first.designpatterns.structural.bridge

import android.health.connect.datatypes.units.Volume

abstract class AbsRemove(device: IDevice) {
    abstract fun setVolume(volume: Int);
    abstract fun volumeDown()
    abstract fun volumeUp()
    abstract fun setChannel(channelNo: Int)
    abstract fun channelDown()
    abstract fun channelUp()
    abstract fun brightnessUp()
    abstract fun brightnessDown()
    abstract fun power()
}

open class RemoteControl(private val device: IDevice) : AbsRemove(device){
    override fun setVolume(volume: Int) {
        device.volume(volume)
    }

    override fun volumeDown() {
        device.volume(device.getVolume() - 1)
    }

    override fun volumeUp() {
        device.volume(device.getVolume() + 1)
    }

    override fun setChannel(channelNo: Int) {
        device.setChannel(channelNo)
    }

    override fun channelDown() {
        device.setChannel(device.getChannel() -1)
    }

    override fun channelUp() {
        device.setChannel(device.getChannel() +1)
    }

    override fun brightnessUp() {
        device.setBrightness(device.getBrightness() +1)
    }

    override fun brightnessDown() {
        device.setBrightness(device.getBrightness() - 1)
    }

    override fun power() {
        device.power()
    }
}

/**
 * Refined abstraction
 * @property device IDevice
 * @constructor
 */
class AdvRemoteControl(private val device: IDevice) : RemoteControl(device){

    fun mute(){
        device.volume(-1)
    }

    override fun power() {
        // disable Power off feature
        //super.power()
    }
}