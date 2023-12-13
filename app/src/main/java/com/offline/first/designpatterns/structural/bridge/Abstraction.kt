package com.offline.first.designpatterns.structural.bridge

interface IRemote {
    fun setVolume(volume: Int) {}
    fun volumeDown() {}
    fun volumeUp() {}
    fun setChannel(channelNo: Int) {}
    fun channelDown() {}
    fun channelUp() {}
    fun brightnessUp() {}
    fun brightnessDown() {}
    fun power() {}
}

abstract class AbsRemote(device: IDevice) : IRemote {
    init {
        device.blinkLED() // Call when remote connected
    }
}

open class RemoteControl(private val device: IDevice) : AbsRemote(device) {
    override fun setVolume(volume: Int) {
        device.volume(volume)
    }

    override fun volumeDown() {
        if (device.getVolume() > 0) {
            device.volume(device.getVolume() - 1)
        }
    }

    override fun volumeUp() {
        if (device.getVolume() < 100) {
            device.volume(device.getVolume() + 1)
        }
    }

    override fun setChannel(channelNo: Int) {
        device.setChannel(channelNo)
    }

    override fun channelDown() {
        device.setChannel(device.getChannel() - 1)
    }

    override fun channelUp() {
        device.setChannel(device.getChannel() + 1)
    }

    override fun brightnessUp() {
        device.setBrightness(device.getBrightness() + 1)
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
class AdvRemoteControl(private val device: IDevice) : RemoteControl(device) {

    fun mute() {
        device.volume(0)
    }

    override fun power() {
        // disable Power off feature
        //super.power()
    }
}