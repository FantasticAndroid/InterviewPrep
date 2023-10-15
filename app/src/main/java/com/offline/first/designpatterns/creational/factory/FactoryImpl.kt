package com.offline.first.designpatterns.creational.factory

import android.util.Log
import com.offline.first.designpatterns.creational.factory.com.phone.AndroidOs
import com.offline.first.designpatterns.creational.factory.com.phone.OsFactory
import com.offline.first.designpatterns.creational.factory.com.phone.BaseOs
import com.offline.first.designpatterns.creational.factory.com.phone.OsType

const val TAG = "FactoryImpl"

/**
 * Define an interface or abstract class for creating an object
 * and let the subclasses decide which class to instantiate.
 *
 * Factory Method Pattern is also known as Virtual Constructor.
 *
 * It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code.
 *
 * The factory method in the interface or abstract class asks its subclasses to implement it.
 *
 * It is one of the best ways to create an object where object creation logic is hidden from the client.
 */
object FactoryImpl {
    fun implementFactoryDesignPattern() {
        val osType: BaseOs = OsFactory.getOs(OsType.ANDROID)
        val spec = osType.spec()
        Log.d(TAG, "spec: $spec")
    }
}