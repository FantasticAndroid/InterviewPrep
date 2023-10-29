package com.offline.first.designpatterns.structural.adapter.com.charger

/**
 * This is an adapter interface, compatible with one of the existing objects.
 */
interface ICharger {
    /**
     * Current to charge iPhone
     * @param current Long
     */
    fun charge(current: Long)
}