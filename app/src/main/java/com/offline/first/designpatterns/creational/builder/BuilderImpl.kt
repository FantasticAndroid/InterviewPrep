package com.offline.first.designpatterns.creational.builder

import android.util.Log
import com.offline.first.designpatterns.creational.builder.com.phone.PhoneFilter
import com.offline.first.designpatterns.creational.factory.com.phone.AndroidOs

/**
 * It says, "construct a complex object from simple objects using step-by-step approach".
 *
 * It aims to "Separate the construction of a complex object from its representation so that
 * the same construction process can create different representations."
 *
 * It is used to construct a complex object step by step and the final step will return the object.
 *
 * The process of constructing an object should be generic so that the same construction process
 * can be used to create different representations of the same object.
 */
object BuilderImpl {

    fun applyBuilderImpl() {
        val builder = PhoneFilter.Builder()
        val phoneFilter = builder
            .priceRange(5000..10000)
            .osType(AndroidOs())
            .hasCamera(true)
            .build()
        Log.d("BuilderImpl", "applyBuilderImpl phoneFilter: $phoneFilter")
    }
}