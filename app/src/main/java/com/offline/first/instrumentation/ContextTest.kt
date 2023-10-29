package com.offline.first.instrumentation

import android.content.Context
import android.util.Log

class ContextTest {

    fun isApplicationContext(context: Context): Boolean {
        return context.applicationContext == context
    }

    fun isFileDeleted(context: Context, file: String): Boolean {
        return context.applicationContext.deleteFile(file)
    }

    fun willThrowException(context: Context?) {
        context?.apply {
            Log.d("willThrowExceptions", "context: ${context.javaClass.simpleName}")
        } ?: throw NullPointerException("Text Null Pointer Exception")
    }

    fun willThrowExceptions(context: Context) {
        //val file = context.cacheDir.listFiles()[0] // Throw Array out of bound exception too
        //Log.d("willThrowExceptions", "File: $file")
    }

}