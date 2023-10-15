package com.offline.first.designpatterns.structural.bridge

const val TAG = "BrideImpl"

object BridgeImpl {

    /**
     * Client
     */
    fun applyBrideImpl() {

        val remoteControl = RemoteControl(TVDevice(power = false))
        remoteControl.power() // To Power on
        remoteControl.volumeUp()

        val advRemoteControl = AdvRemoteControl(TVDevice(power = true))
        advRemoteControl.mute()

        val remoteControlRadio = RemoteControl(RadioDevice(power = true))
        remoteControlRadio.channelDown()
    }
}