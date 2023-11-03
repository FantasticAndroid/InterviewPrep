package com.offline.first.flow

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

private const val TAG = "FlowDemo"

object FlowDemo {

    fun flowOfDemo() {
        val flow = flowOf(1, 2, 3, 4, 5)
            .map { it * 2 }
            .onEach { delay(2000) }
            .flowOn(Dispatchers.IO)

        CoroutineScope(Dispatchers.Main).launch {
            flow.collect {
                Log.d(TAG, "flowOfDemo collect: $it")
            }
        }
    }

    fun asFlowDemo() {
        val flow = (1..5).asFlow()
            .map { it * 2 }
            .onEach { delay(2000) }
            .flowOn(Dispatchers.IO)

        CoroutineScope(Dispatchers.Main).launch {
            flow.collect {
                Log.d(TAG, "asFlowDemo collect: $it")
            }
        }
    }

    fun flowDemo() {
        val flow = flow {
                (1..5).forEach {
                    emit(it)
                }
            }.map { it * 2 }
            .onEach { delay(2000) }
            .flowOn(Dispatchers.IO)

        CoroutineScope(Dispatchers.Main).launch {
            flow.collect {
                Log.d(TAG, "flowDemo collect: $it")
            }
        }
    }

    fun channelFlowDemo() {
        val flow = channelFlow {
            (1..5).forEach {
                send(it)
            }
        }.map { it * 2 }
            .onEach { delay(2000) }
            .flowOn(Dispatchers.IO)

        CoroutineScope(Dispatchers.Main).launch {
            flow.collect {
                Log.d(TAG, "channelFlowDemo collect: $it")
            }
        }
    }
}