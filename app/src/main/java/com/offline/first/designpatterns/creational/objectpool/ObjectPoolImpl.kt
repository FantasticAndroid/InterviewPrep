package com.offline.first.designpatterns.creational.objectpool

import android.util.Log

const val TAG = "ObjectPoolImpl"
object ObjectPoolImpl {

    fun applyObjectPool(){

        val objectPool = object: AbsObjectPool<ExpensiveClass>(2, 5, 5.toLong()){
            override fun createObject(pollIndex: Int): ExpensiveClass {
                return ExpensiveClass(pollIndex)
            }
        }

        val expensiveObject = objectPool.acquireObject()
        Log.d(TAG, "borrowObject: $expensiveObject")
        expensiveObject.doExpensiveOperation()

        objectPool.releaseObject(expensiveObject)

        objectPool.shutdown()
    }
}