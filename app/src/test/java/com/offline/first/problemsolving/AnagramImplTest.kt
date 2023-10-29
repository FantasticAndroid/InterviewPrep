package com.offline.first.problemsolving

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


@RunWith(value = Parameterized::class)
class AnagramImplTest(
    private val string1: String,
    private val string2: String,
    private val expectedValue: Boolean
) {

    @Before
    fun setUp() {
        println("AnagramImplTest SetUp Before")
    }

    @Test
    fun findAnagram() {
        val result = AnagramImpl.findAnagram(string1, string2)
        Assert.assertEquals(expectedValue, result)
    }

    companion object {

        @JvmStatic
        @Parameters(name = "{index} : string1: {0}, string2: {1}. Is Anagram: {2}")
        fun params(): List<Array<Any>> {
            return listOf(
                arrayOf("Mother In Law", "Hitler Woman", true),
                arrayOf("MotherInLaw", "HitlerWoman", true),
                arrayOf("Level", "LEVEL", true),
                arrayOf("Father In Law", "Hitler Father", false)
            )
        }
    }

}