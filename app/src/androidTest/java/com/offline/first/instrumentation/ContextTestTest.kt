package com.offline.first.instrumentation

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContextTestTest {

    private lateinit var contextTest: ContextTest

    @Before
    fun setUp() {
        contextTest = ContextTest()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun isApplicationContext() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = contextTest.isApplicationContext(context)
        Assert.assertNotEquals(false, result)
    }

    @Test
    fun isFileDeleted() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = contextTest.isFileDeleted(context, "invalid.file")
        Assert.assertEquals(false, result)
    }

    @Test(expected = NullPointerException::class)
    fun willThrowException() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        contextTest.willThrowException(null)
    }

    @Test(expected = ArrayIndexOutOfBoundsException::class)
    fun willThrowExceptions() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        contextTest.willThrowExceptions(context)
    }
}