package com.offline.first.designpatterns.creational.factory.com.phone

object OsFactory {

    fun getOs(osType: OsType) : BaseOs = when (osType) {
        OsType.ANDROID -> AndroidOs()
        OsType.IOS -> IOs()
        OsType.WINDOWS -> WindowOs()
    }
}