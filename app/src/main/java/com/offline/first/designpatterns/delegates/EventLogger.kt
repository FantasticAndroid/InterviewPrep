package com.offline.first.designpatterns.delegates

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Delegation is a design pattern that allows you to pass a request to another object,
 * called the delegate. The delegate is responsible for handling the request
 * on behalf of the original object.
 */
interface IEventLogger {
    fun logEvent(eventCode: String, eventMsg: String)
    fun registerUIEvent(owner: LifecycleOwner)
}

/**
 * Let this is third party class to log event
 */
class EventLogManager {
    fun logEvent(eventCode: String, eventMsg: String) {
        Log.d(TAG, "ec: $eventCode, em: $eventMsg")
    }
}

/**
 * @property eventLogManager EventLogManager
 * @constructor
 */
class EventLogger : IEventLogger, LifecycleEventObserver {

    /**
     * Lazy Delegate example
     */
    private val eventLogManager by lazy { EventLogManager() }

    override fun logEvent(eventCode: String, eventMsg: String) {
        eventLogManager.logEvent(eventCode, eventMsg)
    }

    override fun registerUIEvent(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        // Register default UI event
        when (event) {
            Lifecycle.Event.ON_RESUME -> logEvent("ON_RESUME", event.toString())
            Lifecycle.Event.ON_PAUSE -> logEvent("ON_PAUSE", event.toString())
            else -> {}
        }
    }
}