package com.offline.first.designpatterns.creational.objectpool

import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


abstract class AbsObjectPool<T>// initialize pool
    (minObjects: Int, maxObjects: Int, validationInterval: Long) {

    abstract fun createObject(pollIndex: Int): T

    private var pool: ConcurrentLinkedQueue<T> = ConcurrentLinkedQueue()
    private var executorService: ScheduledExecutorService

    init {
        createMinimumObjects(minObjects)

        executorService = Executors.newSingleThreadScheduledExecutor()
        executorService.scheduleWithFixedDelay({
            val size = pool.size
            if (size < minObjects) {
                val sizeToBeAdded = minObjects + size
                for (i in 0 until sizeToBeAdded) {
                    pool.add(createObject(i))
                }
            } else if (size > maxObjects) {
                val sizeToBeRemoved = size - maxObjects
                for (i in 0 until sizeToBeRemoved) {
                    pool.poll()
                }
            }
        }, validationInterval, validationInterval, TimeUnit.SECONDS)
    }

    private fun createMinimumObjects(minObjects: Int) {
        for (i in 0 until minObjects) {
            pool.add(createObject(i))
        }
    }

    fun acquireObject(): T {
        return pool.poll() ?: createObject(0)
    }

    fun releaseObject(objectToReturn: T?) {
        objectToReturn?.let {
            pool.offer(it)
        }
    }

    public fun shutdown() {
        executorService.shutdown();
    }
}